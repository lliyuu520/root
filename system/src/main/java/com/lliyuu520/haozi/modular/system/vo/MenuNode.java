package com.lliyuu520.haozi.modular.system.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 * @author liliangyu
 * @date 2019-08-02
 */
@Data
public class MenuNode {
    /**
     * 菜单起始节点
     */
    public static final String PID = "0";
    /**
     * id
     */
    private Long id;

    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * url
     */
    private String url;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否被勾选
     */
    private Integer checked;
    /**
     * 顺序
     */
    private Integer sort;

    /**
     * 子菜单
     */
    private List<MenuNode> children = new ArrayList<>();


}
