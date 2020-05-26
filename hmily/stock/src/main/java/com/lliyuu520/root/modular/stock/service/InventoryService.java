package com.lliyuu520.root.modular.stock.service;

import com.lliyuu520.root.modular.stock.entity.Inventory;
import org.dromara.hmily.annotation.Hmily;

/**
 * InventoryService
 * @author lliyuu520*/
public interface InventoryService {

    /**
     * 根据产品id查询库存
     * @param productId
     * @return
     */
    Inventory selectByProductId(Long productId);

    /**
     * 扣除库存
     * @param productId
     * @param productNum
     * @return
     */
    @Hmily
    void decreaseInventory(Long productId, Integer productNum);
}
