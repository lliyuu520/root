package com.lliyuu520.root.modular.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.root.modular.system.dto.SysUserDTO;
import com.lliyuu520.root.modular.system.entity.SysUser;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    SysUser loadUserByUsername(String username);

    /**
     * 获取用户信息
     *
     * @return
     */
    SysUser getCurrentUser();


    /**
     * 修改密码密码
     *
     * @param newPassword
     */
    void changePassword(String newPassword);

    /**
     * 重置密码
     *
     * @param userId
     */
    void resetPassword(String userId);


    /**
     * 增加用户
     *
     * @param sysUserDTO
     */
    void addUser(SysUserDTO sysUserDTO);

    /**
     * 编辑用户
     *
     * @param sysUserDTO
     */
    void editUser(SysUserDTO sysUserDTO);

    /**
     * 冻结用户
     *
     * @param id
     */
    void lockUser(String id);

    /**
     * 解锁账户
     *
     * @param id
     */
    void unLockUser(String id);
}
