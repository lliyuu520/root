package com.lliyuu520.root.modular.system.service.impl;


import com.lliyuu520.root.modular.system.entity.SysRole;
import com.lliyuu520.root.modular.system.entity.SysUser;
import com.lliyuu520.root.modular.system.service.SysRoleService;
import com.lliyuu520.root.modular.system.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户权限相关
 */
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements UserDetailsService {

    private final SysUserService IUserService;
    private final SysRoleService IRoleService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //查数据库
        SysUser user = IUserService.loadUserByUsername(userName);
        if (null != user) {
            List<SysRole> roles = IRoleService.getRolesByUserId(user.getId());
            user.setAuthorities(roles);
        }
        return user;
    }
}
