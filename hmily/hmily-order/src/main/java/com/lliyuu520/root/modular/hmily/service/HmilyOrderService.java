package com.lliyuu520.root.modular.hmily.service;

import com.lliyuu520.root.modular.hmily.entity.HmilyOrder;

/**
 * OrderService
 *
 * @author lliyuu520
 */
public interface HmilyOrderService {

    /**
     * 创建订单
     *
     * @param hmilyOrder
     * @return
     */
    void createOrderForm(HmilyOrder hmilyOrder);

    /**
     * 修改支付状态
     *
     * @param id
     * @param payStatus
     */
    void modifyPayStatusById(Long id, Integer payStatus);

    /**
     * getById
     *
     * @param id
     * @return
     */
    HmilyOrder getById(Long id);
}
