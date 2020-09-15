package com.lliyuu520.root.modular.stock.service.impl;

import com.lliyuu520.root.modular.stock.entity.Inventory;
import com.lliyuu520.root.modular.stock.repository.InventoryRepository;
import com.lliyuu520.root.modular.stock.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * integralServiceConfirm
 *
 * @author lliyuu520
 */
@Service
@Slf4j
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Inventory selectByProductId(Long productId) {
        Optional<Inventory> byProductId = inventoryRepository.getByProductId(productId);
        return byProductId.orElse(new Inventory());
    }

    /**
     * 扣除库存,增加冻结
     *
     * @param productId
     * @param productNum
     * @return
     */
    @Override
    @Hmily(confirmMethod = "confirmInventory", cancelMethod = "cancelInventory")
    @Transactional(rollbackFor = Exception.class)
    public void decreaseInventory(Long productId, Integer productNum) {
        log.info("=============执行库存尝试=========");
        Optional<Inventory> byProductId = inventoryRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            Inventory inventory = byProductId.get();
            Integer totalInventory = inventory.getTotalInventory();
            totalInventory = totalInventory - productNum;
            inventory.setTotalInventory(totalInventory);
            inventory.setLockInventory(productNum);
            inventoryRepository.save(inventory);
        }
    }

    /**
     * 扣除冻结
     *
     * @param productId
     * @param productNum
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void confirmInventory(Long productId, Integer productNum) {
        log.info("=============执行库存确认=========");
        Optional<Inventory> byProductId = inventoryRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            Inventory inventory = byProductId.get();
            inventory.setLockInventory(inventory.getLockInventory() - productNum);
            inventoryRepository.save(inventory);
        }

    }

    /**
     * 扣除冻结,回退库存
     *
     * @param productId
     * @param productNum
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancelInventory(Long productId, Integer productNum) {
        log.info("=============执行库存取消=========");
        Optional<Inventory> byProductId = inventoryRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            Inventory inventory = byProductId.get();
            Integer totalInventory = inventory.getTotalInventory();
            totalInventory = totalInventory + productNum;
            inventory.setTotalInventory(totalInventory);
            inventory.setLockInventory(inventory.getLockInventory() - productNum);
            inventoryRepository.save(inventory);
        }
    }
}
