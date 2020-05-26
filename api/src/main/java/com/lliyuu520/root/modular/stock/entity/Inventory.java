package com.lliyuu520.root.modular.stock.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * inventory
 *
 * @author lliyuu520
 */
@Data
@Entity
public class Inventory implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 产品id
     */
    private String productId;

    /**
     * 总库存
     */
    private Integer totalInventory;

    /**
     * 锁定库存
     */
    private Integer lockInventory;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改
     */
    private LocalDateTime updateTime;
    /**
     * 单价
     */
    private BigDecimal productPrice;
}
