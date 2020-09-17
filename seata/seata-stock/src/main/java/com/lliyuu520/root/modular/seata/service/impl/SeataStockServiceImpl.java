package com.lliyuu520.root.modular.seata.service.impl;

import com.lliyuu520.root.modular.seata.entity.SeataStock;
import com.lliyuu520.root.modular.seata.repository.SeataStockRepository;
import com.lliyuu520.root.modular.seata.service.SeataStockService;
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
public class SeataStockServiceImpl implements SeataStockService {

    private final SeataStockRepository seataStockRepository;

    @Override
    public SeataStock selectByProductId(Long productId) {
        Optional<SeataStock> byProductId = seataStockRepository.getByProductId(productId);
        return byProductId.orElse(new SeataStock());
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
        Optional<SeataStock> byProductId = seataStockRepository.getByProductId(productId);
        if (byProductId.isPresent()) {
            SeataStock seataStock = byProductId.get();
            Integer totalInventory = seataStock.getTotalInventory();
            totalInventory = totalInventory - productNum;
            seataStock.setTotalInventory(totalInventory);
            seataStockRepository.save(seataStock);
        }
    }

}
