package com.lliyuu520.root.modular.seata.service.impl;

import com.lliyuu520.root.modular.seata.entity.SeataOrder;
import com.lliyuu520.root.modular.seata.repository.SeataOrderRepository;
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
public class SeataOrderServiceImpl implements SeataOrderService {


    private final SeataOrderRepository seataOrderRepository;

    /**
     * 创建订单
     *
     * @param seataOrder
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrderForm(SeataOrder seataOrder) {
         seataOrderRepository.saveAndFlush(seataOrder);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyPayStatusById(Long id, Integer payStatus) {
        seataOrderRepository.modifyPayStatusById(id, payStatus);
    }

    /**
     * getById
     *
     * @param id
     * @return
     */
    @Override
    public SeataOrder getById(Long id) {
        return seataOrderRepository.getOne(id);
    }
}
