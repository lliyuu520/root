package com.lliyuu520.root.modular.system.entity;


import lombok.Data;

/**
 * 资源
 *
 * @author liliangyu
 */
@Data
public class SysRolePermission {

    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 资源id
     */
    private Long permissionId;


}
