package com.lliyuu520.root.modular.stock.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * inventory
 * @author 
 */
@Data
public class Inventory implements Serializable {
    private Long id;

    private String productId;

    /**
     * 总库存
     */
    private Integer totalInventory;

    /**
     * 锁定库存
     */
    private Integer lockInventory;

    private static final long serialVersionUID = 1L;
}