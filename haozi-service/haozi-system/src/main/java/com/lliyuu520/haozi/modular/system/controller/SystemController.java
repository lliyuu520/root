package com.lliyuu520.haozi.modular.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import com.lliyuu520.haozi.modular.system.entity.SysDept;
import com.lliyuu520.haozi.modular.system.entity.SysRole;
import com.lliyuu520.haozi.modular.system.entity.SysUser;
import com.lliyuu520.haozi.modular.system.service.SysDeptService;
import com.lliyuu520.haozi.modular.system.service.SysPermissionService;
import com.lliyuu520.haozi.modular.system.service.SysRoleService;
import com.lliyuu520.haozi.modular.system.service.SysUserService;
import com.lliyuu520.haozi.modular.system.vo.SysPermissionVO;
import com.lliyuu520.haozi.modular.system.vo.SysUserVO;
import com.lliyuu520.haozi.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统
 */
@RestController
@Slf4j
@RequestMapping("/system")
@RequiredArgsConstructor
public class SystemController {

    private final SysPermissionService sysPermissionService;
    private final SysUserService sysUserService;
    private final SysDeptService sysDeptService;
    private final SysRoleService sysRoleService;

    /**
     * 菜单
     */
    @PostMapping(value = "/menu")
    public AjaxResult<List<Tree<String>>> menu() {
        List<Tree<String>> menuNodeByUserId = sysPermissionService.getMenuNodeByUserId();
        return AjaxResult.success(menuNodeByUserId);

    }

    /**
     * 用户信息
     */
    @PostMapping(value = "/userInfo")
    public AjaxResult<SysUserVO> userInfo() {
        SysUser currentUser = sysUserService.getCurrentUser();
        Long userId = currentUser.getId();
        Long deptId = currentUser.getDeptId();
        SysDept sysDept = sysDeptService.getById(deptId);
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtil.copyProperties(currentUser, sysUserVO);
        if (sysDept != null) {
            sysUserVO.setDeptName(sysDept.getName());
        }
        List<SysRole> roles = sysRoleService.getRolesByUserId(userId);
//        sysUserVO.setRoles(roles);
        return AjaxResult.success(sysUserVO);

    }

    /**
     * 需要加入控制的 结构 url:[role1,role2]
     * 资源权限
     */
    @PostMapping(value = "/permission")
    public AjaxResult<List<SysPermissionVO>> permission() {
        List<SysPermissionVO> rolePermissions = sysPermissionService.getPermissionRole();
        return AjaxResult.success(rolePermissions);

    }
}
