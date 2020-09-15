package com.lliyuu520.root.modular.seata.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.lliyuu520.root.core.exception.AccessException;
import com.lliyuu520.root.feign.SeataAccountFeign;
import com.lliyuu520.root.feign.SeataInventoryFeign;
import com.lliyuu520.root.modular.seata.dto.OrderDTO;
import com.lliyuu520.root.modular.seata.entity.SeataOrder;
import com.lliyuu520.root.modular.seata.enums.OrderStatusEnum;
import com.lliyuu520.root.modular.seata.service.PaymentService;
import com.lliyuu520.root.modular.seata.service.SeataOrderService;
import com.lliyuu520.root.vo.AccountVO;
import com.lliyuu520.root.vo.InventoryVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final SeataInventoryFeign seataInventoryFeign;
    private final SeataAccountFeign seataAccountFeign;
    private final SeataOrderService seataOrderService;

    /**
     * payOrder
     *
     * @param orderDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createHmilyOrder(OrderDTO orderDTO) {
        SeataOrder hmilyOrder = buildOrder(orderDTO);
        seataOrderService.createOrderForm(hmilyOrder);
    }

    /**
     * 构建order
     *
     * @param orderDTO
     * @return
     */
    protected SeataOrder buildOrder(OrderDTO orderDTO) {
        log.info("构建订单对象");
        Long productId = orderDTO.getProductId();
        Integer productNum = orderDTO.getProductNum();
        Long userId = orderDTO.getUserId();

        SeataOrder hmilyOrder = new SeataOrder();
        InventoryVO inventoryVO = seataInventoryFeign.selectByProductId(productId);
        //单价
        BigDecimal productPrice = inventoryVO.getProductPrice();
        hmilyOrder.setOrderNum(RandomUtil.randomNumbers(16));
        hmilyOrder.setProductId(productId);
        hmilyOrder.setPayStatus(OrderStatusEnum.NOT_PAY.getCode());
        BigDecimal totalMoney = NumberUtil.mul(productPrice, productNum);
        hmilyOrder.setTotalMoney(totalMoney);
        hmilyOrder.setProductPrice(productPrice);
        hmilyOrder.setBuyNum(productNum);
        hmilyOrder.setUserId(userId);
        return hmilyOrder;
    }

    /**
     * 订单支付.
     *
     * @param orderId 订单实体
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pay(Long orderId) {

        seataOrderService.modifyPayStatusById(orderId, OrderStatusEnum.PAYING.getCode());
        log.info("=========修改订单状态为{}==========", OrderStatusEnum.PAYING.getDesc());
        SeataOrder hmilyOrder = seataOrderService.getById(orderId);
        Long userId = hmilyOrder.getUserId();
        /*
         订单金额
         */
        BigDecimal totalMoney = hmilyOrder.getTotalMoney();
        /*
         * 账户余额
         */
        AccountVO accountVO = seataAccountFeign.selectByUserId(userId);
        BigDecimal voTotalMoney = accountVO.getTotalMoney();

        if (null == voTotalMoney) {
            voTotalMoney = new BigDecimal("0.00");
        }
        /*
         * 余额小于总金额
         */
        if (voTotalMoney.compareTo(totalMoney) < 1) {
            log.error("账户余额={},订单金额={}", voTotalMoney, totalMoney);
            throw new AccessException("余额不足");
        }

        Long productId = hmilyOrder.getProductId();
        /**
         * 订单数量
         */
        Integer count = hmilyOrder.getBuyNum();
        /**
         * 库存
         */
        InventoryVO inventoryVO = seataInventoryFeign.selectByProductId(productId);
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
        seataAccountFeign.decreaseAccount(userId, totalMoney.toEngineeringString());
        log.info("=========执行扣余额==========");
        /*
        扣库存
         */
        seataInventoryFeign.decreaseInventory(productId, count);
        log.info("=========执行扣库存==========");
    }

    /**
     * 确认
     *
     * @param orderId
     */
    public void confirmOrder(Long orderId) {
        seataOrderService.modifyPayStatusById(orderId, OrderStatusEnum.PAY_SUCCESS.getCode());
        log.info("=========修改订单状态为{}==========", OrderStatusEnum.PAY_SUCCESS.getDesc());

    }

    /**
     * 回滚
     *
     * @param orderId
     */
    public void cancelOrder(Long orderId) {
        seataOrderService.modifyPayStatusById(orderId, OrderStatusEnum.PAY_FAIL.getCode());
        log.info("=========修改订单状态为{}==========", OrderStatusEnum.PAY_FAIL.getDesc());

    }
}
