package com.lliyuu520.consumer.modular.integral.mapper;

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
    int tryReduceIntegral(@Param("integralId") Long integralId,@Param("frozen") Integer frozen);

    /**
     * confirm
     * @param integralId
     * @param frozen
     * @return
     */
    int confirmReduceIntegral(@Param("integralId") Long integralId,@Param("frozen") Integer frozen);

    /**
     * cancle
     * @param integralId
     * @param frozen
     * @return
     */
    int cancelReduceIntegral(@Param("integralId") Long integralId,@Param("frozen") Integer frozen);
}
