package com.lliyuu520.root.modular.seata.service;

import com.lliyuu520.root.modular.seata.entity.SeataOrder;

/**
 * OrderService
 *
 * @author lliyuu520
 */
public interface SeataOrderService {

    /**
     * 创建订单
     *
     * @param seataOrder
     * @return
     */
    void createOrderForm(SeataOrder seataOrder);

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
    SeataOrder getById(Long id);
}
