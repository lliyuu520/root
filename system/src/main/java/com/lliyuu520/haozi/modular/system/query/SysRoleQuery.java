package com.lliyuu520.haozi.modular.system.query;

import com.lliyuu520.haozi.query.BaseQuery;
import lombok.Data;

/**
 * 角色查询
 * @author liliangyu
 * @date 2019-07-31
 */
@Data
public class SysRoleQuery implements BaseQuery {
    /**
     * 名称
     */
    private String name;


}
