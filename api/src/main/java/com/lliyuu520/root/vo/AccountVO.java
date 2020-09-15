package com.lliyuu520.root.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * account
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
