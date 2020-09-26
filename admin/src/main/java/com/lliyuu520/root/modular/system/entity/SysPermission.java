package com.lliyuu520.root.modular.system.entity;


import com.lliyuu520.root.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 资源
 *
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysPermission extends BaseEntity {

    /**
     * url
     */
    private String url;
    /**
     * 名称
     */
    private String name;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 菜单标志
     */
    private Integer menuFlag;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;

}
