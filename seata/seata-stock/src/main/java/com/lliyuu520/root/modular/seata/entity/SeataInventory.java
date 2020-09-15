package com.lliyuu520.root.modular.seata.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * inventory
 *
 * @author lliyuu520
 */
@Data
@Entity
public class SeataInventory implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 总库存
     */
    private Integer totalInventory;

    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createTime;
    /**
     * 修改
     */
    @LastModifiedDate
    private LocalDateTime updateTime;

}
