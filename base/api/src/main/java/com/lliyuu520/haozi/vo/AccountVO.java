package com.lliyuu520.haozi.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 账户
 *
 * @author lliyuu520
 */
@Data
public class AccountVO implements Serializable {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户余额
     */
    private BigDecimal totalMoney;

}
