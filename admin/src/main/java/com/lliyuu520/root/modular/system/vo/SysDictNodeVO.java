package com.lliyuu520.root.modular.system.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
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
     * 英语名称
     */
    private String eName;
    /**
     * 代码
     */
    private String code;
    /**
     * 备注
     */
    private String order;
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
