package com.lliyuu520.haozi.modular.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.modular.account.entity.SeataOrder;
import com.lliyuu520.haozi.modular.account.enums.OrderStatusEnum;

/**
 * OrderService
 *
 * @author lliyuu520
 */
public interface SeataOrderService extends IService<SeataOrder> {

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
    void modifyPayStatusById(Long id, OrderStatusEnum payStatus);


}
