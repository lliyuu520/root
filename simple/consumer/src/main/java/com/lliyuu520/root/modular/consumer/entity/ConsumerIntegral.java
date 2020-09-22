package com.lliyuu520.root.modular.consumer.entity;


import com.lliyuu520.root.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lliyuu520
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConsumerIntegral extends BaseEntity {
    /**
     * name
     */
    private String name;
    /**
     * 积分
     */
    private Integer score;


}
