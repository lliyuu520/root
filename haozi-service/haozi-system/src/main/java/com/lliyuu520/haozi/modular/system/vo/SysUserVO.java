package com.lliyuu520.haozi.modular.system.vo;

import lombok.Data;

/**
 * 用户VO
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


}
