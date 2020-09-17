package com.lliyuu520.root.modular.hmily.repository;

import com.lliyuu520.root.modular.hmily.entity.HmilyAccount;
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
public interface HmilyAccountRepository extends JpaRepository<HmilyAccount, Serializable>, JpaSpecificationExecutor<HmilyAccount> {
    /**
     * findByUserId
     *
     * @param userId
     * @return
     */
    Optional<HmilyAccount> findByUserId(Long userId);
}
