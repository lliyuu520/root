package com.lliyuu520.consumer.modular.integraldetail;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lliyuu520
 * @date 2020/5/1920:42
 */
@Data
public class IntegralDetailDTO  implements Serializable {

    private Long integralId;
    private Integer score;
}
