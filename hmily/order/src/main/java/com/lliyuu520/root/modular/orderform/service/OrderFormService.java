package com.lliyuu520.root.modular.orderform.service;

import com.lliyuu520.root.modular.orderform.entity.OrderForm;

/**
 * OrderService
 *
 * @author lliyuu520
 */
public interface OrderFormService {

    /**
     * 创建订单
     *
     * @param orderForm
     * @return
     */
    void createOrderForm(OrderForm orderForm);

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
    OrderForm getById(Long id);
}
