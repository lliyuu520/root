package com.lliyuu520.root.modular.consumer.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author lliyuu520
 */
public interface IntegralMapper  {
    /**
     * try
     * @param integralId
     * @param frozen
     * @return
     */
    int reduceIntegral(@Param("integralId") Long integralId, @Param("frozen") Integer frozen);

}
