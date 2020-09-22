package com.lliyuu520.root.modular.seata.entity;

import com.lliyuu520.root.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * inventory
 *
 * @author lliyuu520
 */
@Data
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


}
