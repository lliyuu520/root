package com.lliyuu520.root.modular.hmily.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.lliyuu520.root.modular.hmily.entity.HmilyAccount;
import com.lliyuu520.root.modular.hmily.repository.HmilyAccountRepository;
import com.lliyuu520.root.modular.hmily.service.HmilyAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * integralServiceConfirm
 *
 * @author lliyuu520
 */
@Service
@Slf4j
@AllArgsConstructor
public class HmilyAccountServiceImpl implements HmilyAccountService {
    private HmilyAccountRepository hmilyAccountRepository;


    /**
     * 根据userId查询账户
     *
     * @param userId 用户名
     * @return 账户信息
     */
    @Override
    public HmilyAccount selectByUserId(Long userId) {
        return hmilyAccountRepository.findByUserId(userId).orElse(new HmilyAccount());
    }

    /**
     * 扣除余额,增加冻结
     *
     * @param userId
     * @param amount
     * @return
     */
    @Override
    @Hmily(confirmMethod = "confirmAccount", cancelMethod = "cancelAccount")
    public void decreaseAccount(Long userId, BigDecimal amount) {
        log.info("执行账户尝试");
        HmilyAccount one = hmilyAccountRepository.getOne(userId);
        BigDecimal totalMoney = one.getTotalMoney();
        totalMoney= NumberUtil.sub(totalMoney,amount);
        one.setTotalMoney(totalMoney);
        one.setFreezeMoney(amount);
        hmilyAccountRepository.save(one);
    }
    @Transactional(rollbackFor = Exception.class)
    public void confirmAccount(String userId, BigDecimal amount) {
        log.info("执行账户确认");
        HmilyAccount one = hmilyAccountRepository.getOne(userId);
        BigDecimal freezeMoney = one.getFreezeMoney();
        freezeMoney=NumberUtil.sub(freezeMoney,amount);
        one.setFreezeMoney(freezeMoney);
        hmilyAccountRepository.save(one);
    }
    @Transactional(rollbackFor = Exception.class)
    public void cancelAccount(String userId, BigDecimal amount) {
        log.info("执行账户取消");
        HmilyAccount one = hmilyAccountRepository.getOne(userId);
        BigDecimal totalMoney = one.getTotalMoney();
        totalMoney= NumberUtil.add(totalMoney,amount);
        one.setTotalMoney(totalMoney);
        BigDecimal freezeMoney = one.getFreezeMoney();
        freezeMoney=NumberUtil.sub(freezeMoney,amount);
        one.setFreezeMoney(freezeMoney);
        hmilyAccountRepository.save(one);
    }
}
