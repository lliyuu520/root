package com.lliyuu520.root.modular.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author liliangyu
 * @date 2019/7/29
 */
@Data
public class SysPermissionVO {
    /**
     * 角色集合
     */
    private List<String> roles;
    /**
     * 资源
     */
    private String url;
}
