package com.lliyuu520.api.modular.integral;


import lombok.Data;

import java.io.Serializable;

/**
 * 资源
 *
 * @author liliangyu
 */
@Data
public class Integral implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * name
     */
    private String name;
    /**
     * 积分
     */
    private Integer score;
    /**
     * 冻结积分
     */
    private Integer frozen;
    /**
     * 账户ID
     */
    private Long integralId;


}
