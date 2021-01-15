package com.lliyuu520.haozi.modular.system.dto;

import lombok.Data;

/**
 * @author liliangyu
 * @description 部门dto
 * @date 2019-07-31
 */
@Data
public class SysDeptDTO {
    /**
     * id
     */
    private String id;
    /**
     * 名称
     */
    private String name;


    /**
     * 是否系统字段
     */
    private Long parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 排序
     */
    private String remark;


}
