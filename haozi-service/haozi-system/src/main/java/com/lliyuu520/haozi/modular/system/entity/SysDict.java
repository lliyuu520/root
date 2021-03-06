package com.lliyuu520.haozi.modular.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lliyuu520.haozi.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liliangyu
 * @date 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName
public class SysDict extends BaseEntity {


    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 字典编码
     */
    private String code;


}
