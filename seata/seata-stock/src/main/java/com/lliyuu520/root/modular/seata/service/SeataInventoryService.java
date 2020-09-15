package com.lliyuu520.root.modular.seata.service;

import com.lliyuu520.root.modular.seata.entity.SeataInventory;

/**
 * InventoryService
 * @author lliyuu520*/
public interface SeataInventoryService {

    /**
     * 根据产品id查询库存
     * @param productId
     * @return
     */
    SeataInventory selectByProductId(Long productId);

    /**
     * 扣除库存
     * @param productId
     * @param productNum
     * @return
     */
    void decreaseInventory(Long productId, Integer productNum);
}
