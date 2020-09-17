package com.lliyuu520.root.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseEntity
 *
 * @author lliyuu520
 * @since 2020/9/1716:03
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建时间
     */
    @CreationTimestamp
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @UpdateTimestamp
    private LocalDateTime updateTime;
    /**
     * 版本
     */
    @Version
    private Integer version;
}
