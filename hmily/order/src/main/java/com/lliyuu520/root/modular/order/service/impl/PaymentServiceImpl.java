package com.lliyuu520.root.modular.order.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.lliyuu520.root.core.exception.AccessException;
import com.lliyuu520.root.feign.AccountFeign;
import com.lliyuu520.root.feign.InventoryFeign;
import com.lliyuu520.root.modular.order.dto.PayOrderDTO;
import com.lliyuu520.root.modular.order.entiry.Order;
import com.lliyuu520.root.modular.order.enums.OrderStatusEnum;
import com.lliyuu520.root.modular.order.service.OrderService;
import com.lliyuu520.root.modular.order.service.PaymentService;
import com.lliyuu520.root.modular.stock.vo.InventoryVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author lliyuu520
 * @date 2020/5/2315:05
 */
@Service
@Slf4j
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final InventoryFeign inventoryFeign;
    private final AccountFeign accountFeign;
    private final OrderService orderService;

    /**
     * payOrder
     *
     * @param payOrderDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void payOrder(PayOrderDTO payOrderDTO) {
        Long productId = payOrderDTO.getProductId();
        Integer productNum = payOrderDTO.getProductNum();
        Long userId = payOrderDTO.getUserId();
        Order order = orderService.payOrder(payOrderDTO);
        this.makePayment(order);

    }

    /**
     * 构建order
     *
     * @param payOrderDTO
     * @return
     */
    private Order buildOrder(PayOrderDTO payOrderDTO) {
        log.info("构建订单对象");
        Long productId = payOrderDTO.getProductId();
        Order order = new Order();
        InventoryVO inventoryVO = inventoryFeign.selectByProductId(productId);
        BigDecimal productPrice = inventoryVO.getProductPrice();
        order.setOrderNum(RandomUtil.randomNumbers(16));
        order.setProductId(productId);
        order.setPayStatus(OrderStatusEnum.NOT_PAY.getCode());
        NumberUtil.mul()
        order.setTotalMoney();
        order.setCount(payOrderDTO.getProductNum());
        order.setUserId(payOrderDTO.getUserId());
        return order;
    }

    /**
     * 订单支付.
     *
     * @param order 订单实体
     */
    @Override
    @Hmily(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder")
    @Transactional(rollbackFor = Exception.class)
    public void makePayment(Order order) {

        orderService.modifyPayStatusById(order.getId(),OrderStatusEnum.PAYING.getCode());
        log.info("=========修改订单状态为{}==========", OrderStatusEnum.PAYING.getDesc());
        String userId = order.getUserId();
        /*
         订单金额
         */
        BigDecimal totalAmount = order.getTotalAmount();
        /*
         * 账户余额
         */
        BigDecimal accountBalance = accountFeign.selectByUserId(userId);

        if (null == accountBalance) {
            accountBalance = new BigDecimal("0.00");
        }
        /*
         * 余额小于总金额
         */
        if (accountBalance.compareTo(totalAmount) < 1) {
            log.error("账户余额={},订单金额={}", accountBalance, totalAmount);
            throw new AccessException("余额不足");
        }

        String productId = order.getProductId();
        /**
         * 订单数量
         */
        Integer count = order.getCount();
        /**
         * 库存
         */
        InventoryVO inventoryVO = inventoryFeign.selectByProductId(productId);
        Integer totalInventory = inventoryVO.getTotalInventory();
        if (null == totalInventory) {
            totalInventory = 0;
        }
        if (totalInventory.compareTo(count) < 1) {
            log.error("库存={},订单数量={}", count, totalInventory);
            throw new AccessException("库存不足");
        }
        /*
        扣余额
         */
        accountFeign.decreaseAccount(userId, totalAmount.toEngineeringString());
        log.info("=========执行扣余额==========");
        /*
        扣库存
         */
        inventoryFeign.decreaseInventory(productId, count);
        log.info("=========执行扣库存==========");
    }

    /**
     * 确认
     *
     * @param order
     */
    public void confirmOrder(Order order) {
        orderService.modifyPayStatusById(order.getId(),OrderStatusEnum.PAYING.getCode());
        log.info("=========修改订单状态为{}==========", OrderStatusEnum.PAY_SUCCESS.getDesc());

    }

    /**
     * 回滚
     *
     * @param order
     */
    public void cancelOrder(Order order) {
        orderService.modifyPayStatusById(order.getId(),OrderStatusEnum.PAY_FAIL.getCode());
        log.info("=========修改订单状态为{}==========", OrderStatusEnum.PAY_FAIL.getDesc());

    }
}
