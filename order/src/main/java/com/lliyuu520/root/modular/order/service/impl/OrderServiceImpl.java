package com.lliyuu520.root.modular.order.service.impl;

import com.lliyuu520.root.modular.order.mapper.OrderMapper;
import com.lliyuu520.root.modular.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * integralServiceConfirm
 *
 * @author liliangyu
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;


}
