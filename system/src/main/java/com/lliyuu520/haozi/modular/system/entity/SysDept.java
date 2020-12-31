package com.lliyuu520.haozi.modular.system.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.lliyuu520.haozi.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 部门
 *
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDept extends Model<SysDept> {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 创建时间
     */

    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 逻辑删除
     */
    private Integer delFlag;
    /**
     * 顺序
     */
    private Integer weight;

    /**
     * 名称
     */
    private String name;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 备注
     */
    private String remark;


}
