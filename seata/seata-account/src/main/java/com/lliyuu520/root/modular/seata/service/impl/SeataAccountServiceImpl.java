package com.lliyuu520.root.modular.seata.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.lliyuu520.root.modular.seata.entity.SeataAccount;
import com.lliyuu520.root.modular.seata.repository.SeataAccountRepository;
import com.lliyuu520.root.modular.seata.service.SeataAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class SeataAccountServiceImpl implements SeataAccountService {
    private SeataAccountRepository seataAccountRepository;


    /**
     * 根据userId查询账户
     *
     * @param userId 用户名
     * @return 账户信息
     */
    @Override
    public SeataAccount selectByUserId(Long userId) {
        return seataAccountRepository.findByUserId(userId).orElse(new SeataAccount());
    }

    /**
     * 扣除余额,增加冻结
     *
     * @param userId
     * @param amount
     * @return
     */
    @Override
    public void decreaseAccount(Long userId, BigDecimal amount) {
        log.info("执行账户尝试");
        SeataAccount one = seataAccountRepository.getOne(userId);
        BigDecimal totalMoney = one.getTotalMoney();
        totalMoney = NumberUtil.sub(totalMoney, amount);
        one.setTotalMoney(totalMoney);
        one.setFreezeMoney(amount);
        seataAccountRepository.save(one);
    }

    @Transactional(rollbackFor = Exception.class)
    public void confirmAccount(String userId, BigDecimal amount) {
        log.info("执行账户确认");
        SeataAccount one = seataAccountRepository.getOne(userId);
        BigDecimal freezeMoney = one.getFreezeMoney();
        freezeMoney = NumberUtil.sub(freezeMoney, amount);
        one.setFreezeMoney(freezeMoney);
        seataAccountRepository.save(one);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancelAccount(String userId, BigDecimal amount) {
        log.info("执行账户取消");
        SeataAccount one = seataAccountRepository.getOne(userId);
        BigDecimal totalMoney = one.getTotalMoney();
        totalMoney = NumberUtil.add(totalMoney, amount);
        one.setTotalMoney(totalMoney);
        BigDecimal freezeMoney = one.getFreezeMoney();
        freezeMoney = NumberUtil.sub(freezeMoney, amount);
        one.setFreezeMoney(freezeMoney);
        seataAccountRepository.save(one);
    }
}
