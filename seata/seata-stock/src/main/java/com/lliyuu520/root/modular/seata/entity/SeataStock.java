package com.lliyuu520.root.modular.seata.entity;

import com.lliyuu520.root.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * inventory
 *
 * @author lliyuu520
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SeataStock extends BaseEntity {

    /**
     * 产品id
     */
    private Long productId;
    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 总库存
     */
    private Integer totalInventory;
    /**
     * 名称
     */
    private String name;


}
