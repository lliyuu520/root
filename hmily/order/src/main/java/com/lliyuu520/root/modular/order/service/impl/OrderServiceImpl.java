package com.lliyuu520.root.modular.order.service.impl;

import com.lliyuu520.root.modular.order.dto.PayOrderDTO;
import com.lliyuu520.root.modular.order.entiry.Order;
import com.lliyuu520.root.modular.order.repository.OrderRepository;
import com.lliyuu520.root.modular.order.service.OrderService;
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
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;

    /**
     * 支付订单
     *
     * @param payOrderDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order payOrder(PayOrderDTO payOrderDTO) {
        Order order = buildOrder(payOrderDTO);
        orderRepository.save(order);
        return order;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyPayStatusById(Long id, Integer payStatus) {
        orderRepository.modifyPayStatusById(id, payStatus);
    }

}
