package com.lliyuu520.root.modular.hmily.service.impl;

import com.lliyuu520.root.modular.hmily.entity.HmilyStock;
import com.lliyuu520.root.modular.hmily.repository.HmilyStockRepository;
import com.lliyuu520.root.modular.hmily.service.HmilyStockService;
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
public class HmilyStockServiceImpl implements HmilyStockService {

    private final HmilyStockRepository hmilyStockRepository;

    @Override
    public HmilyStock selectByProductId(Long productId) {
        Optional<HmilyStock> byProductId = hmilyStockRepository.getByProductId(productId);
        return byProductId.orElse(new HmilyStock());
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
        Optional<HmilyStock> byProductId = hmilyStockRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            HmilyStock hmilyStock = byProductId.get();
            Integer totalInventory = hmilyStock.getTotalInventory();
            totalInventory = totalInventory - productNum;
            hmilyStock.setTotalInventory(totalInventory);
            hmilyStock.setLockInventory(productNum);
            hmilyStockRepository.save(hmilyStock);
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
        Optional<HmilyStock> byProductId = hmilyStockRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            HmilyStock hmilyStock = byProductId.get();
            hmilyStock.setLockInventory(hmilyStock.getLockInventory() - productNum);
            hmilyStockRepository.save(hmilyStock);
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
        Optional<HmilyStock> byProductId = hmilyStockRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            HmilyStock hmilyStock = byProductId.get();
            Integer totalInventory = hmilyStock.getTotalInventory();
            totalInventory = totalInventory + productNum;
            hmilyStock.setTotalInventory(totalInventory);
            hmilyStock.setLockInventory(hmilyStock.getLockInventory() - productNum);
            hmilyStockRepository.save(hmilyStock);
        }
    }
}
