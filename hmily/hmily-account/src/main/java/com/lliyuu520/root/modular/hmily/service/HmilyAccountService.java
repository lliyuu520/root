package com.lliyuu520.root.modular.hmily.service;

import com.lliyuu520.root.modular.hmily.entity.HmilyAccount;
import org.dromara.hmily.annotation.Hmily;

import java.math.BigDecimal;

/**
 * 账户service
 * @author lliyuu520
 */
public interface HmilyAccountService {


    /**
     * 根据userId查询账户
     *
     * @param userId
     * @return
     */
    HmilyAccount selectByUserId(Long userId);

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
