package com.lliyuu520.root.modular.hmilyorder.service;

import com.lliyuu520.root.modular.hmilyorder.entity.HmilyOrder;

/**
 * OrderService
 *
 * @author lliyuu520
 */
public interface OrderFormService {

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
