package com.lliyuu520.root.modular.consumer.service;

/**
 * IntegralService
 * @author lliyuu520*/
public interface IntegralService {
    /**
     * 扣积分
     * @param integralId
     * @param frozen
     * @return
     */
    void reduceIntegral(Long integralId,Integer frozen);
}
