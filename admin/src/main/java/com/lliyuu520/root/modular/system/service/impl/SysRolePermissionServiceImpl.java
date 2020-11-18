package com.lliyuu520.root.modular.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.modular.system.entity.SysRolePermission;
import com.lliyuu520.root.modular.system.mapper.SysRolePermissionMapper;
import com.lliyuu520.root.modular.system.service.SysRolePermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {
    /**
     * 根据角色ID删除
     *
     * @param roleId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByRoleId(String roleId) {
        this.baseMapper.deleteByRoleId(roleId);
    }
}
