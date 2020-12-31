package com.lliyuu520.haozi.modular.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Hero)实体类
 *
 * @author lliyuu520
 * @since 2020-12-31 14:12:18
 */
@Data
public class Hero implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;


}
