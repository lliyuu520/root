package com.lliyuu520.root.modular.system.entity;


import com.lliyuu520.root.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门
 *
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDept extends BaseEntity {

    /**
     * 中文名称
     */
    private String name;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 排序
     */
    private String icon;
    /**
     * 备注
     */
    private String remark;


}
