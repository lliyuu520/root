package com.lliyuu520.haozi.modular.account.entity;

import com.lliyuu520.haozi.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * account
 *
 * @author lliyuu520
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SeataAccount extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户余额
     */
    private BigDecimal totalMoney;

}
