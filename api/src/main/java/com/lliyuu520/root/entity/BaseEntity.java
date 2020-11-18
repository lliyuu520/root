package com.lliyuu520.root.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseEntity
 *
 * @author lliyuu520
 * @since 2020/9/1716:03
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 创建时间
     */
    @EqualsAndHashCode.Exclude
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @EqualsAndHashCode.Exclude
    private LocalDateTime updateTime;
    /**
     * 逻辑删除
     */
    private Integer delFlag;
    /**
     * 顺序
     */
    private Integer weight;
}
