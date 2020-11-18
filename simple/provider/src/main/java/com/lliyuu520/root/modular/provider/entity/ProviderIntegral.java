package com.lliyuu520.root.modular.provider.entity;


import com.lliyuu520.root.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lliyuu520
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProviderIntegral extends BaseEntity {

    /**
     * name
     */
    private String name;
    /**
     * 积分
     */
    private Integer score;


}
