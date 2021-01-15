package com.lliyuu520.haozi.modular.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.haozi.modular.account.entity.SeataOrder;
import com.lliyuu520.haozi.modular.account.enums.OrderStatusEnum;
import com.lliyuu520.haozi.modular.account.mapper.SeataOrderMapper;
import com.lliyuu520.haozi.modular.account.service.SeataOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * integralServiceConfirm
 *
 * @author lliyuu520
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SeataOrderServiceImpl extends ServiceImpl<SeataOrderMapper, SeataOrder> implements SeataOrderService {


    /**
     * 创建订单
     *
     * @param seataOrder
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrderForm(SeataOrder seataOrder) {
        this.save(seataOrder);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyPayStatusById(Long id, OrderStatusEnum payStatus) {
        SeataOrder seataOrder = this.getById(id);
        seataOrder.setPayStatus(payStatus.getCode());
        this.updateById(seataOrder);
    }


}
