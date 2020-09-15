package com.lliyuu520.root.modular.provider.repository;

import com.lliyuu520.root.modular.provider.entity.ProviderIntegral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * SysUserRepository
 *
 * @author lliyuu520
 * @Since 2020/8/18
 */
@Repository
public interface ProviderIntegralRepository extends JpaRepository<ProviderIntegral, Serializable>, JpaSpecificationExecutor<ProviderIntegral> {


}
