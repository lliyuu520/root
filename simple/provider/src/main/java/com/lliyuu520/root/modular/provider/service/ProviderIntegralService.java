package com.lliyuu520.root.modular.provider.service;

/**
 * IntegralService
 *
 * @author lliyuu520
 */
public interface ProviderIntegralService {
    /**
     * 转账
     *
     * @param integralId
     * @param frozen
     */
    void addProviderIntegral(Long integralId, Integer frozen);

}
