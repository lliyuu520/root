package com.lliyuu520.haozi.modular.system.dto;

import lombok.Data;

/**
 * @author liliangyu
 * @description 字典查询
 * @date 2019-07-31
 */
@Data
public class SysPermissionDTO {
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 英文名称
     */
    private String eName;
    /**
     * 代码
     */
    private String code;
    /**
     * 排序
     */
    private Integer order;


}
