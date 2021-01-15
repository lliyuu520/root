package com.lliyuu520.haozi.modular.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.modular.account.entity.SeataStock;

/**
 * InventoryService
 * @author lliyuu520*/
public interface SeataStockService extends IService<SeataStock> {

    /**
     * 根据产品id查询库存
     * @param productId
     * @return
     */
    SeataStock selectByProductId(Long productId);

    /**
     * 扣除库存
     * @param productId
     * @param productNum
     * @return
     */
    void decreaseInventory(Long productId, Integer productNum);
}
