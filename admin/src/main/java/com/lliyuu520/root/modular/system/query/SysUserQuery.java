package com.lliyuu520.root.modular.system.query;

import lombok.Data;

/**
 * 用户DTO
 *
 * @author liliangyu
 * @date 2019-08-05
 */
@Data
public class SysUserQuery {

    /**
     * 账户
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

}
