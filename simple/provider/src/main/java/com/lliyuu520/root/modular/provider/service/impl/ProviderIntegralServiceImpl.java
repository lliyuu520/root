package com.lliyuu520.root.modular.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.modular.provider.entity.ProviderIntegral;
import com.lliyuu520.root.modular.provider.mapper.ProviderIntegralMapper;
import com.lliyuu520.root.modular.provider.service.ProviderIntegralService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * integralServiceConfirm
 *
 * @author lliyuu520
 */
@Service
@Slf4j
@AllArgsConstructor
public class ProviderIntegralServiceImpl extends ServiceImpl<ProviderIntegralMapper, ProviderIntegral> implements ProviderIntegralService {


    /**
     * 将冻结移入积分
     *
     * @param integralId
     * @param frozen
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProviderIntegral(Long integralId, Integer frozen) {
        ProviderIntegral one = this.baseMapper.selectById(integralId);
        one.setScore(one.getScore() + frozen);
        baseMapper.insert(one);
    }
}
