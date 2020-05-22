package com.lliyuu520.root.modular.account.controller;


import com.lliyuu520.root.modular.account.entity.Account;
import com.lliyuu520.root.modular.account.service.AccountService;
import com.lliyuu520.root.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
     * try 写入冻结 加
     *
     * @param integralId
     * @param frozen
     * @return
     */

    @PostMapping(value = "/add")
    public void addIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {

    }

    @GetMapping("/{id}")
    public AjaxResult selectById(@PathVariable Long id) {
        Account account = accountService.selectByPrimaryKey(id);
        return AjaxResult.success(account);
    }


}
