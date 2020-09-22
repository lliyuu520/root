package com.lliyuu520.root.modular.consumer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.root.modular.consumer.entity.ConsumerIntegral;

/**
 * IntegralService
 * @author lliyuu520*/
public interface ConsumerIntegralService extends IService<ConsumerIntegral> {
    /**
     * 扣积分
     * @param integralId
     * @param frozen
     * @return
     */
    void reduceIntegral(Long integralId,Integer frozen);
}
