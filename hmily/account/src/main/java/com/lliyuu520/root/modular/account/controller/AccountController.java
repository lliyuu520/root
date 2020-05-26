package com.lliyuu520.root.modular.account.controller;


import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.root.modular.account.entity.Account;
import com.lliyuu520.root.modular.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;


    /**
     * 根据userId查询账户
     *
     * @param userId
     * @return
     */
    @GetMapping("/selectByUserId/{userId}")
    public BigDecimal selectByUserId(@PathVariable Long userId) {
        Account account = accountService.selectByUserId(userId);
        if (BeanUtil.isEmpty(account)) {
            return new BigDecimal("0.00");
        } else {
            return account.getTotalMoney();
        }

    }

    /**
     * 扣除余额,增加冻结
     *
     * @param userId
     * @return
     */
    @PostMapping("/decreaseAccount")
    @Hmily
    public void decreaseAccount(@RequestParam Long userId, @RequestParam String amount) {
        BigDecimal amountBigDecimal = new BigDecimal(amount);
        accountService.decreaseAccount(userId, amountBigDecimal);

    }

}
