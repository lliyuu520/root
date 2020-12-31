package com.lliyuu520.haozi.modular.system.query;

import com.lliyuu520.haozi.query.BaseQuery;
import lombok.Data;

/**
 * @author liliangyu
 * @date 2019-07-31
 */
@Data
public class SysDeptQuery implements BaseQuery {
    /**
     * 名称
     */
    private String name;
    /**
     * 英文名称
     */
    private String eName;

}
