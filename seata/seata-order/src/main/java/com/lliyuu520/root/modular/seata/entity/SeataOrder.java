package com.lliyuu520.root.modular.seata.entity;

import com.lliyuu520.root.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


/**
 * orderForm
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
