package com.lliyuu520.root.modular.seata.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.lliyuu520.root.core.exception.BusinessException;
import com.lliyuu520.root.feign.SeataAccountFeign;
import com.lliyuu520.root.feign.SeataInventoryFeign;
import com.lliyuu520.root.modular.seata.dto.OrderDTO;
import com.lliyuu520.root.modular.seata.entity.SeataOrder;
import com.lliyuu520.root.modular.seata.enums.OrderStatusEnum;
import com.lliyuu520.root.modular.seata.service.PaymentService;
import com.lliyuu520.root.modular.seata.service.SeataOrderService;
import com.lliyuu520.root.vo.AccountVO;
import com.lliyuu520.root.vo.InventoryVO;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
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
    public void createOrder(OrderDTO orderDTO) {
        SeataOrder seataOrder = buildOrder(orderDTO);
        seataOrderService.createOrderForm(seataOrder);
    }

    /**
     * 构建order
     *
     * @param orderDTO
     * @return
     */
    protected SeataOrder buildOrder(OrderDTO orderDTO) {
        log.info("构建订单对象:orderDTO:{}", orderDTO);
        //产品id
        Long productId = orderDTO.getProductId();
        //数量
        Integer productNum = orderDTO.getProductNum();
        //用户
        Long userId = orderDTO.getUserId();

        SeataOrder seataOrder = new SeataOrder();

        InventoryVO inventoryVO = seataInventoryFeign.selectByProductId(productId);
        log.info("库存:inventoryVO:{}", inventoryVO);
        //单价
        BigDecimal productPrice = inventoryVO.getProductPrice();
        seataOrder.setOrderNum(RandomUtil.randomNumbers(16));
        seataOrder.setProductId(productId);
        seataOrder.setPayStatus(OrderStatusEnum.NOT_PAY.getCode());
        BigDecimal totalMoney = NumberUtil.mul(productPrice, productNum);
        seataOrder.setTotalMoney(totalMoney);
        seataOrder.setProductPrice(productPrice);
        seataOrder.setBuyNum(productNum);
        seataOrder.setUserId(userId);
        return seataOrder;
    }

    /**
     * 支付失败
     *
     * @param orderId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void payFail(Long orderId) {
        seataOrderService.modifyPayStatusById(orderId, OrderStatusEnum.PAY_FAIL);

    }

    /**
     * 订单支付.
     *
     * @param orderId 订单实体
     */
    @Override
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void pay(Long orderId) throws BusinessException {
        SeataOrder seataOrder = seataOrderService.getById(orderId);
        final Integer payStatus = seataOrder.getPayStatus();
        if (NumberUtil.equals(OrderStatusEnum.PAYING.getCode(), payStatus)) {
            //订单支付中
            throw new BusinessException("订单支付中");
        }
        if (NumberUtil.equals(OrderStatusEnum.PAY_SUCCESS.getCode(), payStatus)) {
            //订单已支付
            throw new BusinessException("订单已支付");
        }

        seataOrderService.modifyPayStatusById(orderId, OrderStatusEnum.PAYING);

        log.info("=========修改订单状态为{}==========", OrderStatusEnum.PAYING.getDesc());
        /**
         * 用户ID
         */
        Long userId = seataOrder.getUserId();
        /*
         订单金额
         */
        BigDecimal totalMoney = seataOrder.getTotalMoney();
        /*
         * 账户余额
         */
        AccountVO accountVO = seataAccountFeign.selectByUserId(userId);

        BigDecimal accountVOTotalMoney = accountVO.getTotalMoney();

        if (null == accountVOTotalMoney) {
            accountVOTotalMoney = new BigDecimal("0.00");
        }
        /*
         * 余额小于总金额
         */
        if (accountVOTotalMoney.compareTo(totalMoney) < 1) {
            log.error("账户余额={},订单金额={}", accountVOTotalMoney, totalMoney);
            throw new BusinessException("余额不足");
        }

        Long productId = seataOrder.getProductId();
        /**
         * 订单数量
         */
        Integer count = seataOrder.getBuyNum();
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
            throw new BusinessException("库存不足");
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
        //支付成功
        seataOrderService.modifyPayStatusById(orderId, OrderStatusEnum.PAY_SUCCESS);

    }


}
