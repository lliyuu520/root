package com.lliyuu520.root.entity;


import com.lliyuu520.root.enums.LockFlagEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class SysUser extends BaseEntity implements UserDetails {

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
     * 英文名称
     */
    private String eName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 性别 1男 2女
     */
    private Integer sex;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 部门ID
     */
    private String deptId;
    /**
     * 锁定状态 0正常 1锁定
     */
    private Integer lockFlag;
    /**
     * 职位
     */
    private String positionName;
    /**
     * 角色集合
     */
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
