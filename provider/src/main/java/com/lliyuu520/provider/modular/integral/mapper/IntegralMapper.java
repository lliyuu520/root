package com.lliyuu520.provider.modular.integral.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author lliyuu520
 */
public interface IntegralMapper  {
    /**
     * try
     * @param integralId
     * @param frozen
     */
    int tryAddIntegral(@Param("integralId") Long integralId, @Param("frozen") Integer frozen);

    /**
     * confirm
     * @param integralId
     * @param frozen
     * @return 执行行数
     */
    int confirmAddIntegral(@Param("integralId") Long integralId, @Param("frozen") Integer frozen);

    /**
     * cancel
     * @param integralId
     * @param frozen
     */
    int cancelAddIntegral(@Param("integralId") Long integralId, @Param("frozen") Integer frozen);

}
