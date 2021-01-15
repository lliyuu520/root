package com.lliyuu520.haozi.modular.area.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 部门
 *
 * @author liliangyu
 */
@Data
public class Area {

    /**
     * 名称
     */
    private String name;
    /**
     * 父code
     */
    private Long parentCode;

    /**
     * code
     */
    @TableId
    private Long code;

    /**
     * 等级
     */
    private Integer level;

}
