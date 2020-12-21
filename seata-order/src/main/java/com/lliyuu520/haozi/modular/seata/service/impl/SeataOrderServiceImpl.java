package com.lliyuu520.haozi.modular.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.haozi.modular.seata.entity.SeataOrder;
import com.lliyuu520.haozi.modular.seata.enums.OrderStatusEnum;
import com.lliyuu520.haozi.modular.seata.mapper.SeataOrderMapper;
import com.lliyuu520.haozi.modular.seata.service.SeataOrderService;
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
