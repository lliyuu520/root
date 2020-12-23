package com.lliyuu520.haozi.modular.system.vo;

import com.lliyuu520.haozi.modular.system.entity.SysRole;
import lombok.Data;

import java.util.List;

/**
 * @author liliangyu
 * @date 2019/7/29
 */
@Data
public class SysUserVO {
    /**
     * 账户名
     */
    private String username;
    /**
     * 中文名称
     */
    private String name;
    /**
     * 英文名称
     */
    private String eName;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 性别
     */
    private String sexValue;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 职位
     */
    private String positionName;
    /**
     * 角色
     */
    private List<SysRole> roles;
}
