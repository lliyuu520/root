package com.lliyuu520.root.modular.account.service;

import com.lliyuu520.root.modular.account.entity.Account;
import org.dromara.hmily.annotation.Hmily;

import java.math.BigDecimal;

/**
 * 账户service
 * @author lliyuu520
 */
public interface AccountService {


    /**
     * 根据userId查询账户
     *
     * @param userId
     * @return
     */
    Account selectByUserId(Long userId);

    /**
     * 扣除余额,增加冻结
     *
     * @param userId
     * @param amount
     * @return
     */
    @Hmily
    void decreaseAccount(Long userId, BigDecimal amount);
}
