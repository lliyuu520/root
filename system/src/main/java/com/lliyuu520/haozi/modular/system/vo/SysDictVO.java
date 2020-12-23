package com.lliyuu520.haozi.modular.system.vo;

import lombok.Data;

import java.util.List;

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
     * 子字典
     */
    private List<SysDictVO> children;
}
