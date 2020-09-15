package com.lliyuu520.root.modular.provider.service.impl;

import com.lliyuu520.root.modular.provider.entity.ProviderIntegral;
import com.lliyuu520.root.modular.provider.repository.ProviderIntegralRepository;
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
public class ProviderIntegralServiceImpl implements ProviderIntegralService {
    private final ProviderIntegralRepository providerIntegralRepository;


    /**
     * 将冻结移入积分
     *
     * @param integralId
     * @param frozen
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProviderIntegral(Long integralId, Integer frozen) {
        ProviderIntegral one = providerIntegralRepository.getOne(integralId);
        one.setScore(one.getScore() + frozen);
        providerIntegralRepository.save(one);
    }
}
