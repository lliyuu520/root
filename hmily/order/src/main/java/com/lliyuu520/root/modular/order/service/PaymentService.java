package com.lliyuu520.root.modular.order.service;


import com.lliyuu520.root.modular.order.dto.PayOrderDTO;
import com.lliyuu520.root.modular.order.entiry.Order;

/**
 * PaymentService.
 *
 * @author lliyuu520
 */
public interface PaymentService {

    /**
     * 订单支付.
     *
     * @param order 订单实体
     */
    void makePayment(Order order);

    /**
     * payOrder
     * @param payOrderDTO
     */
    void payOrder(PayOrderDTO payOrderDTO);

}
