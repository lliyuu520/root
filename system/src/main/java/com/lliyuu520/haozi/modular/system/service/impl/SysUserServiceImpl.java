package com.lliyuu520.haozi.modular.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.haozi.enums.LockFlagEnum;
import com.lliyuu520.haozi.common.properties.ConfigProperties;
import com.lliyuu520.haozi.core.utils.PasswordUtil;
import com.lliyuu520.haozi.modular.system.dto.SysUserDTO;
import com.lliyuu520.haozi.modular.system.entity.SysUser;
import com.lliyuu520.haozi.modular.system.mapper.SysUserMapper;
import com.lliyuu520.haozi.modular.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final ConfigProperties configProperties;

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
        if(authentication==null){
            SysUser sysUser = new SysUser();
            return sysUser;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof SysUser) {
            return (SysUser) principal;
        } else {
            SysUser sysUser = new SysUser();
            sysUser.setName(principal.toString());
            return sysUser;
        }

    }

    /**
     * 重置密码
     *
     * @param userId
     */
    @Override
    public void resetPassword(String userId) {
        SysUser user = this.getById(userId);

        String defaultPassword = configProperties.getDefaultPassword();
        String encode = PasswordUtil.encode(defaultPassword);
        user.setPassword(encode);
        SysUser userDB = loadUserByUsername(user.getUsername());
        userDB.setPassword(user.getPassword());
        this.updateById(userDB);
    }

    /**
     * 初始化用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void loadDefaultUser() {
        SysUser haozi = this.loadUserByUsername("haozi");
        if (haozi == null) {
            String encode = PasswordUtil.encode("123456");
            SysUser sysUser = new SysUser("haozi", encode, "haozi", LockFlagEnum.UN_LOCK.getKey());
            this.save(sysUser);
        } else {
            log.info("用户存在");
        }
    }

    /**
     * 增加用户
     *
     * @param sysUserDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(SysUserDTO sysUserDTO) {
        SysUser sysUser = new SysUser();
        String defaultPassword = configProperties.getDefaultPassword();
        String encode = PasswordUtil.encode(defaultPassword);
        sysUser.setPassword(encode);
        sysUser.setCreateTime(LocalDateTimeUtil.now());
        sysUser.setLockFlag(LockFlagEnum.UN_LOCK.getKey());
        this.save(sysUser);
    }

    /**
     * 编辑用户
     *
     * @param sysUserDTO
     */
    @Override
    public void editUser(SysUserDTO sysUserDTO) {
        Long id = sysUserDTO.getId();
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
