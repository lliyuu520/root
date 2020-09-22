package com.lliyuu520.root.modular.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.modular.seata.entity.SeataOrder;
import com.lliyuu520.root.modular.seata.mapper.SeataOrderMapper;
import com.lliyuu520.root.modular.seata.service.SeataOrderService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class SeataOrderServiceImpl extends ServiceImpl<SeataOrderMapper, SeataOrder> implements SeataOrderService {


    /**
     * 创建订单
     *
     * @param seataOrder
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrderForm(SeataOrder seataOrder) {
        this.baseMapper.insert(seataOrder);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyPayStatusById(Long id, Integer payStatus) {
        SeataOrder seataOrder = this.baseMapper.selectById(id);
        seataOrder.setPayStatus(payStatus);
        this.baseMapper.updateById(seataOrder);
    }

    /**
     * getById
     *
     * @param id
     * @return
     */
    @Override
    public SeataOrder getById(Long id) {
        return this.baseMapper.selectById(id);
    }
}
