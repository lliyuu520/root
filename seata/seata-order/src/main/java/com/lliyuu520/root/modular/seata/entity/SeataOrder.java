package com.lliyuu520.root.modular.seata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * orderForm
 *
 * @author
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SeataOrder implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    /**
     * 创建时间
     */
    @CreatedDate
    private Date createTime;
    /**
     * 更新时间
     */
    @LastModifiedDate
    private Date updateTime;


}
