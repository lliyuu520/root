package com.lliyuu520.haozi.modular.system.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典详情vo
 * @author liliangyu
 * @date 2019/7/29
 */
@Data
public class SysDictNodeVO {

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
     * 是否菜单
     */
    private Integer sysFlag;
    /**
     * 子属性
     *
     */
    List<SysDictNodeVO> children = new ArrayList<>();
}
