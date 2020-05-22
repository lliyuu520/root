package com.lliyuu520.root.modular.account.service;

import com.lliyuu520.root.modular.account.entity.Account;

public interface AccountService {
    /**
     * 根据主键查找
     * @param id
     * @return
     */
  Account selectByPrimaryKey(Long id);
}
