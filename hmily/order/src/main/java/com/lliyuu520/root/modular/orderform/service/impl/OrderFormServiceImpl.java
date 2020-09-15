package com.lliyuu520.root.modular.orderform.service.impl;

import com.lliyuu520.root.modular.orderform.entity.OrderForm;
import com.lliyuu520.root.modular.orderform.repository.OrderFormRepository;
import com.lliyuu520.root.modular.orderform.service.OrderFormService;
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
public class OrderFormServiceImpl implements OrderFormService {


    private final OrderFormRepository orderFormRepository;

    /**
     * 创建订单
     *
     * @param orderForm
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrderForm(OrderForm orderForm) {
         orderFormRepository.saveAndFlush(orderForm);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyPayStatusById(Long id, Integer payStatus) {
        orderFormRepository.modifyPayStatusById(id, payStatus);
    }

    /**
     * getById
     *
     * @param id
     * @return
     */
    @Override
    public OrderForm getById(Long id) {
        return orderFormRepository.getOne(id);
    }
}
