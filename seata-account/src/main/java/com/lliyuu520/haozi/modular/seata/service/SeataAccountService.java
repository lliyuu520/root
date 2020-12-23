package com.lliyuu520.haozi.modular.seata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.modular.seata.entity.SeataAccount;

import java.math.BigDecimal;

/**
 * 账户service
 * @author lliyuu520
 */
public interface SeataAccountService extends IService<SeataAccount> {


    /**
     * 根据userId查询账户
     *
     * @param userId
     * @return
     */
    SeataAccount selectByUserId(Long userId);

    /**
     * 扣除余额,增加冻结
     *
     * @param userId
     * @param amount
     * @return
     */
    void decreaseAccount(Long userId, BigDecimal amount);
}
