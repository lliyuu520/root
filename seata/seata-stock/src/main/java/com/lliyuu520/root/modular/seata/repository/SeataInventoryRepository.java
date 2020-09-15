package com.lliyuu520.root.modular.seata.repository;

import com.lliyuu520.root.modular.seata.entity.SeataInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

/**
 * InventoryRepository
 *
 * @author lliyuu520
 * @since 2020/9/1415:21
 */
@Repository
public interface SeataInventoryRepository extends JpaRepository<SeataInventory, Serializable>, JpaSpecificationExecutor<SeataInventory> {

    /**
     * 根据产品ID查询
     *
     * @param productId
     * @return
     */
    Optional<SeataInventory> getByProductId(Long productId);
}
