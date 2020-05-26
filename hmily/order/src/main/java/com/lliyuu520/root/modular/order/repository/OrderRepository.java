package com.lliyuu520.root.modular.order.repository;

import com.lliyuu520.root.modular.order.entiry.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

/**
 * OrderRepository
 *
 * @author lliyuu520
 * @since 2020/9/1416:07
 */
public interface OrderRepository extends JpaRepository<Order, Serializable>, JpaSpecificationExecutor<Order> {
    /**
     * 修改支付状态
     * @param id
     * @param payStatus
     */
    @Modifying
    @Query(value = "update Order o set o.payStatus = :payStatus , o.updateTime = CURRENT_TIMESTAMP where o.id= :id")
    void modifyPayStatusById(@Param("id") Long id,@Param("payStatus")  Integer payStatus);
}
