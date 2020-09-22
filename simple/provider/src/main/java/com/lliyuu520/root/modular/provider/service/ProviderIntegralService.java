package com.lliyuu520.root.modular.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.root.modular.provider.entity.ProviderIntegral;

/**
 * IntegralService
 *
 * @author lliyuu520
 */
public interface ProviderIntegralService extends IService<ProviderIntegral> {
    /**
     * 转账
     *
     * @param integralId
     * @param frozen
     */
    void addProviderIntegral(Long integralId, Integer frozen);

}
