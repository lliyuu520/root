package com.lliyuu520.root.modular.stock.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * inventory
 *
 * @author lliyuu520
 */
@Data
public class InventoryVO implements Serializable {

    /**
     * 产品id
     */
    private String productId;

    /**
     * 总库存
     */
    private Integer totalInventory;

    /**
     * 单价
     */
    private BigDecimal productPrice;
}
