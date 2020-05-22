package com.lliyuu520.root.modular.provider.mapper;

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
    int addIntegral(@Param("integralId") Long integralId, @Param("frozen") Integer frozen);

}
