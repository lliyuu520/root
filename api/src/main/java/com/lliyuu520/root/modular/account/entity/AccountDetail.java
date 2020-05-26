package com.lliyuu520.root.modular.account.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * AccountDetail
 * @author lliyuu520*/
@Data
public class AccountDetail implements Serializable {
    private Long id;

    /**
     * 用户ID
     */
    private String userId;

    private BigDecimal amount;

    private Date createTime;


    private static final long serialVersionUID = 1L;
}
