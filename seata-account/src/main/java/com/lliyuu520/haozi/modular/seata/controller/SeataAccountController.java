package com.lliyuu520.haozi.modular.seata.controller;


import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.haozi.modular.seata.entity.SeataAccount;
import com.lliyuu520.haozi.modular.seata.service.SeataAccountService;
import com.lliyuu520.haozi.vo.AccountVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/seataAccount")
@Slf4j
@RequiredArgsConstructor
public class SeataAccountController {

    private final SeataAccountService seataAccountService;


    /**
     * 根据userId查询账户
     *
     * @param userId
     * @return
     */
    @GetMapping("/selectByUserId/{userId}")
    public AccountVO selectByUserId(@PathVariable Long userId) {
        SeataAccount account = seataAccountService.selectByUserId(userId);
        return BeanUtil.copyProperties(account, AccountVO.class);

    }

    /**
     * 扣除余额,增加冻结
     *
     * @param userId
     * @return
     */
    @PostMapping("/decreaseAccount")
    public void decreaseAccount(@RequestParam Long userId, @RequestParam String amount) {
        BigDecimal amountBigDecimal = new BigDecimal(amount);
        seataAccountService.decreaseAccount(userId, amountBigDecimal);

    }

}
