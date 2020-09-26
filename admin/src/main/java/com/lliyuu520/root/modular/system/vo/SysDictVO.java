package com.lliyuu520.root.modular.system.vo;

import lombok.Data;

/**
 * @author liliangyu
 * @date 2019/7/29
 */
@Data
public class SysDictVO {

    /**
     * id
     */
    private String id;
    /**
     * 中文名称
     */
    private String name;
    /**
     * 代码
     */
    private String code;
    /**
     * 父节点名称
     */
    private String parentName;
    /**
     * 父节点编码
     */
    private String parentCode;
}
