package com.lliyuu520.root.modular.system.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.lliyuu520.root.common.enums.LockFlagEnum;
import com.lliyuu520.root.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

/**
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity implements UserDetails, Serializable {

    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 中文名称
     */
    private String name;

    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 锁定状态 0正常 1锁定
     */
    private Integer lockFlag;
    /**
     * 角色集合
     */
    @TableField(exist = false)
    private List<SysRole> authorities;


    @Override
    public List<SysRole> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SysRole> authorities) {
        this.authorities = authorities;
    }

    /**
     * 用户账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户账号是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {

        return LockFlagEnum.UN_LOCK.getKey().equals(this.lockFlag);

    }

    /**
     * 用户密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
