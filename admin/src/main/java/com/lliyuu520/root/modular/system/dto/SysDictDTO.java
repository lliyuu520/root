package com.lliyuu520.root.modular.system.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liliangyu
 * @description 字典查询
 * @date 2019-07-31
 */
@Data
public class SysDictDTO {
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
     * 是否系统字段
     */
    private Integer sysFlag;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 子字典
     */
    private List<SysDictDTO> sysDictDTOList = new ArrayList<>(0);

}
