package com.lliyuu520.root.modular.account.repository;

import com.lliyuu520.root.modular.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

/**
 * SysUserRepository
 *
 * @author lliyuu520
 * @Since 2020/8/18
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Serializable>, JpaSpecificationExecutor<Account> {
    /**
     * findByUserId
     *
     * @param userId
     * @return
     */
    Optional<Account> findByUserId(Long userId);
}
