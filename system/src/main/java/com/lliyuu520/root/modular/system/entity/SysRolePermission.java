package com.lliyuu520.root.modular.system.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 资源
 *
 * @author liliangyu
 */
@Data
public class SysRolePermission {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 资源id
     */
    private Long permissionId;


}
