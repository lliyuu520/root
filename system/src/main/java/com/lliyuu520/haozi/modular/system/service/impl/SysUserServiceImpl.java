package com.lliyuu520.haozi.modular.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.haozi.common.properties.ConfigProperties;
import com.lliyuu520.haozi.core.utils.PasswordUtil;
import com.lliyuu520.haozi.enums.DelFlagEnum;
import com.lliyuu520.haozi.enums.LockFlagEnum;
import com.lliyuu520.haozi.modular.system.dto.SysUserDTO;
import com.lliyuu520.haozi.modular.system.entity.SysDept;
import com.lliyuu520.haozi.modular.system.entity.SysUser;
import com.lliyuu520.haozi.modular.system.mapper.SysUserMapper;
import com.lliyuu520.haozi.modular.system.query.SysUserQuery;
import com.lliyuu520.haozi.modular.system.service.SysDeptService;
import com.lliyuu520.haozi.modular.system.service.SysDictService;
import com.lliyuu520.haozi.modular.system.service.SysUserService;
import com.lliyuu520.haozi.modular.system.vo.SysUserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final ConfigProperties configProperties;
    private final SysDeptService sysDeptService;

    private final SysDictService sysDictService;

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public SysUser loadUserByUsername(String username) {
        final LambdaQueryWrapper<SysUser> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(SysUser::getUsername,username);
        return this.getOne(wrapper);

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
        if (authentication == null) {
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
    public void resetPassword(Long userId) {
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
        sysUser.setLockFlag(LockFlagEnum.UN_LOCK.getKey());
        sysUser.setDelFlag(DelFlagEnum.NONE.getKey());
        BeanUtil.copyProperties(sysUserDTO,sysUser);
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
    public void lockUser(Long id) {
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
    public void unLockUser(Long id) {
        SysUser sysUser = this.getById(id);
        sysUser.setLockFlag(LockFlagEnum.UN_LOCK.getKey());
        this.updateById(sysUser);
    }

    /**
     * listByQuery
     *
     * @param sysUserQuery
     * @return
     */
    @Override
    public List<SysUserVO> listByQuery(SysUserQuery sysUserQuery) {
        final LambdaQueryWrapper<SysUser> wrapper = Wrappers.lambdaQuery();
        final String name = sysUserQuery.getName();
        if (StrUtil.isNotEmpty(name)) {
            wrapper.like(SysUser::getName, name);
        }
        final String username = sysUserQuery.getUsername();
        if (StrUtil.isNotEmpty(username)) {
            wrapper.like(SysUser::getUsername, username);
        }
        final String phone = sysUserQuery.getPhone();
        if (StrUtil.isNotEmpty(phone)) {
            wrapper.like(SysUser::getPhone, phone);
        }
        wrapper.orderByDesc(SysUser::getWeight);
        final List<SysUser> list = this.list(wrapper);
        final List<SysUserVO> collect = list.stream().map(sysUser -> {
            final SysUserVO sysUserVO = BeanUtil.copyProperties(sysUser, SysUserVO.class);
            final Long deptId = sysUser.getDeptId();
            final SysDept sysDept = sysDeptService.getById(deptId);
            if (sysDept != null) {
                sysUserVO.setDeptName(sysDept.getName());
            }
            final String sex = sysUser.getSex();
            final String gender = sysDictService.getValueByKey("gender", sex);
            sysUserVO.setSexValue(gender);
            return sysUserVO;
        }).collect(Collectors.toList());
        return collect;
    }
}
