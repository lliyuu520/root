package com.lliyuu520.root.modular.account.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * account
 * @author 
 */
@Data
public class Account implements Serializable {
    private Long id;

    private String userId;

    /**
     * 用户余额
     */
    private Long balance;

    /**
     * 冻结金额，扣款暂存余额
     */
    private Long freezeAmount;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}