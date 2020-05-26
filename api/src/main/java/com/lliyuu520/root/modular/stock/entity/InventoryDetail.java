package com.lliyuu520.root.modular.stock.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * inventory
 *
 * @author lliyuu520
 */
@Data
public class InventoryDetail implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 产品id
     */
    private String productId;

    /**
     * 总库存
     */
    private Integer num;

    /**
     * 创建时间
     */
    private Date createTime;

}
