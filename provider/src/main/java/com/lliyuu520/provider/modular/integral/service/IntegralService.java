package com.lliyuu520.provider.modular.integral.service;

public interface IntegralService {
    /**
     * 转账
     * @param integralId
     * @param frozen
     */
  void  addIntegral(Long integralId,Integer frozen);

}
