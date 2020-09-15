package com.lliyuu520.root.modular.seata.service.impl;

import com.lliyuu520.root.modular.seata.entity.SeataInventory;
import com.lliyuu520.root.modular.seata.repository.SeataInventoryRepository;
import com.lliyuu520.root.modular.seata.service.SeataInventoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class SeataInventoryServiceImpl implements SeataInventoryService {

    private final SeataInventoryRepository seataInventoryRepository;

    @Override
    public SeataInventory selectByProductId(Long productId) {
        Optional<SeataInventory> byProductId = seataInventoryRepository.getByProductId(productId);
        return byProductId.orElse(new SeataInventory());
    }

    /**
     * 扣除库存,增加冻结
     *
     * @param productId
     * @param productNum
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseInventory(Long productId, Integer productNum) {
        log.info("=============执行库存尝试=========");
        Optional<SeataInventory> byProductId = seataInventoryRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            SeataInventory seataInventory = byProductId.get();
            Integer totalInventory = seataInventory.getTotalInventory();
            totalInventory = totalInventory - productNum;
            seataInventory.setTotalInventory(totalInventory);
            seataInventory.setLockInventory(productNum);
            seataInventoryRepository.save(seataInventory);
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
        Optional<SeataInventory> byProductId = seataInventoryRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            SeataInventory seataInventory = byProductId.get();
            seataInventory.setLockInventory(seataInventory.getLockInventory() - productNum);
            seataInventoryRepository.save(seataInventory);
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
        Optional<SeataInventory> byProductId = seataInventoryRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            SeataInventory seataInventory = byProductId.get();
            Integer totalInventory = seataInventory.getTotalInventory();
            totalInventory = totalInventory + productNum;
            seataInventory.setTotalInventory(totalInventory);
            seataInventory.setLockInventory(seataInventory.getLockInventory() - productNum);
            seataInventoryRepository.save(seataInventory);
        }
    }
}
