package com.lliyuu520.haozi.modular.system.dto;

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
     * 代码
     */
    private String code;
    /**
     * 排序
     */
    private Integer weight;

    /**
     * 子字典
     */
    private List<SysDictDTO> sysDictDTOs = new ArrayList<>(0);

}
