package com.lliyuu520.root.modular.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.common.enums.LockFlagEnum;
import com.lliyuu520.root.common.properties.XlyyProperties;
import com.lliyuu520.root.core.utils.PasswordUtil;
import com.lliyuu520.root.modular.system.dto.SysUserDTO;
import com.lliyuu520.root.modular.system.entity.SysUser;
import com.lliyuu520.root.modular.system.mapper.SysUserMapper;
import com.lliyuu520.root.modular.system.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final XlyyProperties xlyyProperties;

    @Override
    public SysUser loadUserByUsername(String username) {
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        SysUser user = new SysUser();
        user.setUsername(username);
        userQueryWrapper.setEntity(user);
        return this.getOne(userQueryWrapper);

    }

    /**
     * 修改密码密码
     *
     * @param newPassword
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changePassword(String newPassword) {
        SysUser user = this.getCurrentUser();
        String username = user.getUsername();
        SysUser sysUser = this.loadUserByUsername(username);
        sysUser.setPassword(PasswordUtil.encode(newPassword));
        this.updateById(sysUser);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @Override
    public SysUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();
        if (principal instanceof SysUser) {
            return (SysUser) principal;
        } else {
            SysUser sysUser = new SysUser();
            sysUser.setName(principal.toString());
            return sysUser;
        }

    }

    @Override
    public void resetPassword(String userId) {
        SysUser user = this.getById(userId);

        String defaultPassword = xlyyProperties.getDefaultPassword();
        String encode = PasswordUtil.encode(defaultPassword);
        user.setPassword(encode);
        SysUser userDB = loadUserByUsername(user.getUsername());
        userDB.setPassword(user.getPassword());
        this.updateById(userDB);
    }


    /**
     * 增加用户
     *
     * @param sysUserDTO
     */
    @Override
    public void addUser(SysUserDTO sysUserDTO) {
        SysUser sysUser = new SysUser();
        String defaultPassword = xlyyProperties.getDefaultPassword();
        String encode = PasswordUtil.encode(defaultPassword);
        sysUser.setPassword(encode);
        sysUser.setCreateTime(new Date());
        sysUser.setLockFlag(LockFlagEnum.LOCK.getKey());
        this.save(sysUser);
    }

    /**
     * 编辑用户
     *
     * @param sysUserDTO
     */
    @Override
    public void editUser(SysUserDTO sysUserDTO) {
        String id = sysUserDTO.getId();
        SysUser sysUser = this.getById(id);
        BeanUtil.copyProperties(sysUserDTO, sysUser);
        this.updateById(sysUser);
    }

    /**
     * 锁定账户
     *
     * @param id
     */
    @Override
    public void lockUser(String id) {
        SysUser sysUser = this.getById(id);
        sysUser.setLockFlag(LockFlagEnum.LOCK.getKey());
        this.updateById(sysUser);
    }

    /**
     * 锁定账户
     *
     * @param id
     */
    @Override
    public void unLockUser(String id) {
        SysUser sysUser = this.getById(id);
        sysUser.setLockFlag(LockFlagEnum.UN_LOCK.getKey());
        this.updateById(sysUser);
    }
}
