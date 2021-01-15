package com.lliyuu520.haozi.modular.system.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lliyuu520.haozi.enums.DelFlagEnum;
import com.lliyuu520.haozi.enums.LockFlagEnum;
import com.lliyuu520.haozi.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SysUser extends BaseEntity implements UserDetails, Serializable {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 逻辑删除
     */
    private Integer delFlag;
    /**
     * 顺序
     */
    private Integer weight;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 名称
     */
    private String name;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 锁定状态 0正常 1锁定
     */
    private Integer lockFlag;
    /**
     * 性别
     */
    private String sex;
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

    public SysUser(String username, String password, String name, Integer lockFlag) {
        super.setDelFlag(DelFlagEnum.NONE.getKey());
        super.setCreateTime(LocalDateTime.now());
        super.setUpdateTime(LocalDateTime.now());
        this.username = username;
        this.password = password;
        this.name = name;
        this.lockFlag = lockFlag;
    }
}
