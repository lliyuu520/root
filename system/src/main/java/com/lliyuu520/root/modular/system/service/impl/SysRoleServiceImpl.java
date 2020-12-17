package com.lliyuu520.root.modular.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.common.content.Global;
import com.lliyuu520.root.modular.system.dto.SysRolePermissionDTO;
import com.lliyuu520.root.modular.system.entity.SysRole;
import com.lliyuu520.root.modular.system.entity.SysRolePermission;
import com.lliyuu520.root.modular.system.mapper.SysRoleMapper;
import com.lliyuu520.root.modular.system.service.SysPermissionService;
import com.lliyuu520.root.modular.system.service.SysRolePermissionService;
import com.lliyuu520.root.modular.system.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    private final SysRolePermissionService sysRolePermissionService;
    private final SysPermissionService permissionService;

    @Override
    public List<SysRole> getRolesByUserId(Long userId) {
        return this.baseMapper.getSysRolesByUserId(userId);
    }

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    @Override
    public SysRole getByName(String name) {
        LambdaQueryWrapper<SysRole> query = Wrappers.lambdaQuery(SysRole.class);
        if (StrUtil.isNotBlank(name)) {
            query.like(SysRole::getName, name);
        }
        return this.getOne(query);
    }

    /**
     * 配置角色
     * 配置角色后,需要刷新系统存放的相关资源
     *
     * @param list
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void config(List<SysRolePermissionDTO> list) {
        list.forEach(dto -> {
            String roleId = dto.getRoleId();
            sysRolePermissionService.deleteByRoleId(roleId);
        });
        list.forEach(dto -> {
            SysRolePermission sysRolePermission = new SysRolePermission();
            BeanUtil.copyProperties(dto, sysRolePermission);
            sysRolePermissionService.save(sysRolePermission);
        });
        Global.urlRoles = permissionService.getRolePermission();
    }
}
