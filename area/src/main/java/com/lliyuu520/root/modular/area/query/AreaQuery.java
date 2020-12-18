package com.lliyuu520.root.modular.area.query;

import com.lliyuu520.root.query.BaseQuery;
import lombok.Data;

/**
 * 地址位置信息查询
 *
 * @author liliangyu
 * @date 2019-07-31
 */
@Data
public class AreaQuery implements BaseQuery {

    /**
     * 父编码
     */
    private Long parentCode;
    /**
     * 编码
     */
    private Long code;


}
