package com.lliyuu520.root.modular.account.service.impl;

import com.lliyuu520.root.modular.account.entity.Account;
import com.lliyuu520.root.modular.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * integralServiceConfirm
 *
 * @author liliangyu
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountService accountService;

    @Override
    public Account selectByPrimaryKey(Long id) {
        return accountService.selectByPrimaryKey(id);
    }
}
