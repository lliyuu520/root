package com.lliyuu520.root.modular.seata.entity;

import com.lliyuu520.root.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


/**
 * orderForm
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SeataOrder extends BaseEntity {


    /**
     * 订单编号
     */
    private String orderNum;
    /**
     * 支付状态
     */
    private Integer payStatus;
    /**
     * 产品ID
     */
    private Long productId;
    /**
     * 总金额
     */
    private BigDecimal totalMoney;
    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 购买数量
     */
    private Integer buyNum;
    /**
     * 用户ID
     */
    private Long userId;


}
