package com.lliyuu520.root.modular.order.entiry;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * order
 * @author
 */
@Data
public class Order implements Serializable {
    private Long id;

    private Date createTime;

    private String number;

    private Byte status;

    private String productId;

    private Long totalAmount;

    private Integer count;

    private String userId;

    private static final long serialVersionUID = 1L;
}