package com.lliyuu520.haozi.modular.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.haozi.modular.account.entity.SeataStock;
import com.lliyuu520.haozi.modular.account.mapper.SeataStockMapper;
import com.lliyuu520.haozi.modular.account.service.SeataStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * integralServiceConfirm
 *
 * @author lliyuu520
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SeataStockServiceImpl extends ServiceImpl<SeataStockMapper, SeataStock> implements SeataStockService {

    /**
     * 根据产品id查询库存
     *
     * @param productId
     * @return
     */
    @Override
    public SeataStock selectByProductId(Long productId) {

        LambdaQueryWrapper<SeataStock> query = Wrappers.lambdaQuery(SeataStock.class);
        query.eq(SeataStock::getProductId, productId);
        return this.getOne(query);
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
        LambdaQueryWrapper<SeataStock> query = Wrappers.lambdaQuery(SeataStock.class);
        query.eq(SeataStock::getProductId, productId);
        SeataStock seataStock = this.getOne(query);
        Integer totalInventory = seataStock.getTotalInventory();
        totalInventory = totalInventory - productNum;
        seataStock.setTotalInventory(totalInventory);
        this.save(seataStock);

    }

}
