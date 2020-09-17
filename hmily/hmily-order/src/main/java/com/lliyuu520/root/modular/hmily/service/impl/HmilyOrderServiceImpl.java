package com.lliyuu520.root.modular.hmily.service.impl;

import com.lliyuu520.root.modular.hmily.entity.HmilyOrder;
import com.lliyuu520.root.modular.hmily.repository.HmilyOrderRepository;
import com.lliyuu520.root.modular.hmily.service.HmilyOrderService;
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
public class HmilyOrderServiceImpl implements HmilyOrderService {


    private final HmilyOrderRepository hmilyOrderRepository;

    /**
     * 创建订单
     *
     * @param hmilyOrder
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrderForm(HmilyOrder hmilyOrder) {
         hmilyOrderRepository.saveAndFlush(hmilyOrder);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyPayStatusById(Long id, Integer payStatus) {
        hmilyOrderRepository.modifyPayStatusById(id, payStatus);
    }

    /**
     * getById
     *
     * @param id
     * @return
     */
    @Override
    public HmilyOrder getById(Long id) {
        return hmilyOrderRepository.getOne(id);
    }
}
