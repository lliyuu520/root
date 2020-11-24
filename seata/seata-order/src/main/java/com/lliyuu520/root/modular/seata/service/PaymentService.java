package com.lliyuu520.root.modular.seata.service;


import com.lliyuu520.root.core.exception.BusinessException;
import com.lliyuu520.root.modular.seata.dto.OrderDTO;

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
    void pay(Long  orderId) throws BusinessException;

    /**
     * payOrder
     * @param orderDTO
     */
    void createOrder(OrderDTO orderDTO);

    /**
     * 支付失败
     * @param orderId
     */
    void payFail(Long orderId);

}
