package com.lliyuu520.haozi.modular.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.modular.system.entity.SysRolePermission;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {
    /**
     * 根据角色ID删除
     *
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}
