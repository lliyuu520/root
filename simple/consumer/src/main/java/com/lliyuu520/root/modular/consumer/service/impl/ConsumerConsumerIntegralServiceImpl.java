package com.lliyuu520.root.modular.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.feign.ProviderIntegralFeign;
import com.lliyuu520.root.modular.consumer.entity.ConsumerIntegral;
import com.lliyuu520.root.modular.consumer.mapper.ConsumerIntegralMapper;
import com.lliyuu520.root.modular.consumer.service.ConsumerIntegralService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lliyuu520
 * @date 2020/5/2121:39
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerConsumerIntegralServiceImpl extends ServiceImpl<ConsumerIntegralMapper, ConsumerIntegral> implements ConsumerIntegralService {

    private final ProviderIntegralFeign providerIntegralFeign;

    /**
     * 扣积分
     * @param integralId
     * @param frozen
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reduceIntegral(Long integralId, Integer frozen) {
        ConsumerIntegral one = this.baseMapper.selectById(integralId);
        one.setScore(one.getScore() - frozen);
        this.baseMapper.insert(one);
        providerIntegralFeign.addIntegral(integralId, frozen);
    }
}
