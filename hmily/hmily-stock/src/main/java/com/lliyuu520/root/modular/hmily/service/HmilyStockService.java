package com.lliyuu520.root.modular.hmily.service;

import com.lliyuu520.root.modular.hmily.entity.HmilyStock;
import org.dromara.hmily.annotation.Hmily;

/**
 * HmilyStockService
 * @author lliyuu520*/
public interface HmilyStockService {

    /**
     * 根据产品id查询库存
     * @param productId
     * @return
     */
    HmilyStock selectByProductId(Long productId);

    /**
     * 扣除库存
     * @param productId
     * @param productNum
     * @return
     */
    @Hmily
    void decreaseInventory(Long productId, Integer productNum);
}
