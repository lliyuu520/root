package com.lliyuu520.root.modular.system.query;

import com.lliyuu520.root.query.BaseQuery;
import lombok.Data;

/**
 * @author liliangyu
 * @description 字典查询
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
