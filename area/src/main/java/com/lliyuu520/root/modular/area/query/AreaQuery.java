package com.lliyuu520.root.modular.area.query;

import com.lliyuu520.root.query.BaseQuery;
import lombok.Data;

/**
 * @author liliangyu
 * @description 字典查询
 * @date 2019-07-31
 */
@Data
public class AreaQuery implements BaseQuery {

    /**
     * parentCode
     */
    private Long parentCode;
    /**
     * code
     */
    private Long code;


}
