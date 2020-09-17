package com.lliyuu520.root.modular.hmily.controller;


import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.root.modular.hmily.entity.HmilyAccount;
import com.lliyuu520.root.modular.hmily.service.HmilyAccountService;
import com.lliyuu520.root.vo.AccountVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/hmilyAccount")
@Slf4j
@AllArgsConstructor
public class HmilyAccountController {

    private final HmilyAccountService hmilyAccountService;


    /**
     * 根据userId查询账户
     *
     * @param userId
     * @return
     */
    @GetMapping("/selectByUserId/{userId}")
    public AccountVO selectByUserId(@PathVariable Long userId) {
        HmilyAccount hmilyAccount = hmilyAccountService.selectByUserId(userId);
        return BeanUtil.copyProperties(hmilyAccount, AccountVO.class);

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
        hmilyAccountService.decreaseAccount(userId, amountBigDecimal);

    }

}
