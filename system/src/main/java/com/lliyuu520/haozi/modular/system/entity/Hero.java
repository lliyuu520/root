package com.lliyuu520.haozi.modular.system.entity;


import com.lliyuu520.haozi.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 英雄
 *
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Hero extends BaseEntity {

    /**
     * 名称
     */
    private String name;



}
