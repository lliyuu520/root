package com.lliyuu520.haozi.modular.system.query;

import com.lliyuu520.haozi.query.BaseQuery;
import lombok.Data;

/**
 * 用户查询
 *
 * @author liliangyu
 * @date 2019-08-05
 */
@Data
public class SysUserQuery implements BaseQuery {

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
