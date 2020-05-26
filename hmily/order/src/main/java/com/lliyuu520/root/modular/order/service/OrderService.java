package com.lliyuu520.root.modular.order.service;

import com.lliyuu520.root.modular.order.dto.PayOrderDTO;
import com.lliyuu520.root.modular.order.entiry.Order;

public interface OrderService {

    /**
     * 支付订单
     *
     * @param payOrderDTO
     */
    Order payOrder(PayOrderDTO payOrderDTO);

    /**
     * 修改支付状态
     *
     * @param id
     * @param payStatus
     */
    void modifyPayStatusById(Long id, Integer payStatus);
}
