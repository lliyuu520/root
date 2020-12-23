package com.lliyuu520.haozi.modular.system.dto;

import lombok.Data;

/**
 * 角色DTO
 *
 * @author liliangyu
 * @date 2019-08-05
 */
@Data
public class SysRolePermissionDTO {
    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 资源ID
     */
    private String permissionId;
}
