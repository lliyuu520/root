package com.lliyuu520.root.modular.seata.repository;

import com.lliyuu520.root.modular.seata.entity.SeataStock;
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
public interface SeataStockRepository extends JpaRepository<SeataStock, Serializable>, JpaSpecificationExecutor<SeataStock> {

    /**
     * 根据产品ID查询
     *
     * @param productId
     * @return
     */
    Optional<SeataStock> getByProductId(Long productId);
}
