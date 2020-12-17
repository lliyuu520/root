package com.lliyuu520.root.modular.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.root.modular.system.dto.SysRolePermissionDTO;
import com.lliyuu520.root.modular.system.entity.SysRole;

import java.util.List;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 根据用户 ID查询用户角色
     * @param userId
     * @return
     */
    List<SysRole> getRolesByUserId(Long userId);

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    SysRole getByName(String name);

    /**
     * 配置角色
     *
     * @param list
     */
    void config(List<SysRolePermissionDTO> list);
}
