package com.lliyuu520.root.modular.hmily.service;


import com.lliyuu520.root.modular.hmily.dto.OrderDTO;

/**
 * PaymentService.
 *
 * @author lliyuu520
 */
public interface PaymentService {

    /**
     * 订单支付.
     *
     * @param orderId 订单实体
     */
    void pay(Long  orderId);

    /**
     * payOrder
     * @param orderDTO
     */
    void createHmilyOrder(OrderDTO orderDTO);

}
