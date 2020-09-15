package com.lliyuu520.root.modular.seata.repository;

import com.lliyuu520.root.modular.seata.entity.SeataAccount;
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
public interface SeataAccountRepository extends JpaRepository<SeataAccount, Serializable>, JpaSpecificationExecutor<SeataAccount> {
    /**
     * findByUserId
     *
     * @param userId
     * @return
     */
    Optional<SeataAccount> findByUserId(Long userId);
}
