package com.lliyuu520.root.modular.system.service;


import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.root.core.config.UrlRole;
import com.lliyuu520.root.modular.system.entity.SysPermission;
import com.lliyuu520.root.modular.system.vo.MenuNode;
import com.lliyuu520.root.modular.system.vo.SysPermissionVO;

import java.util.List;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
public interface SysPermissionService extends IService<SysPermission> {
    /**
     * 根据用户名查询用户
     *
     * @return
     */
    List<UrlRole> getRolePermission();

    /**
     * 获取资源角色
     *
     * @return
     */
    List<SysPermissionVO> getPermissionRole();

    /**
     * 获取菜单结构树
     * @param roleId  角色ID
     * @return
     */
    List<Tree<String>> getMenuNodeByRoleId(Long roleId);

    /**
     * 获取用户菜单
     *
     * @return
     */
    List<Tree<String>>getMenuNodeByUserId();

}
