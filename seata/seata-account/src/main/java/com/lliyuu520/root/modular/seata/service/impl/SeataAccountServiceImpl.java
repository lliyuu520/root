package com.lliyuu520.root.modular.seata.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.modular.seata.entity.SeataAccount;
import com.lliyuu520.root.modular.seata.mapper.SeataAccountMapper;
import com.lliyuu520.root.modular.seata.service.SeataAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * integralServiceConfirm
 *
 * @author lliyuu520
 */
@Service
@Slf4j
@AllArgsConstructor
public class SeataAccountServiceImpl extends ServiceImpl<SeataAccountMapper, SeataAccount> implements SeataAccountService {


    /**
     * 根据userId查询账户
     *
     * @param userId 用户名
     * @return 账户信息
     */
    @Override
    public SeataAccount selectByUserId(Long userId) {
        LambdaQueryWrapper<SeataAccount> queryWrapper = Wrappers.lambdaQuery(SeataAccount.class);
        queryWrapper.eq(SeataAccount::getUserId, userId);
        return this.baseMapper.selectOne(queryWrapper);
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
        SeataAccount one = this.baseMapper.selectById(userId);
        BigDecimal totalMoney = one.getTotalMoney();
        totalMoney = NumberUtil.sub(totalMoney, amount);
        one.setTotalMoney(totalMoney);
        baseMapper.insert(one);
    }

}
