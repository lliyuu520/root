package com.lliyuu520.root.modular.provider.service.impl;

import com.lliyuu520.root.modular.integral.entity.Integral;
import com.lliyuu520.root.modular.provider.repository.IntegralRepository;
import com.lliyuu520.root.modular.provider.service.IntegralService;
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
public class IntegralServiceImpl implements IntegralService {
    private final IntegralRepository integralRepository;


    /**
     * 将冻结移入积分
     *
     * @param integralId
     * @param frozen
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addIntegral(Long integralId, Integer frozen) {
        Integral one = integralRepository.getOne(integralId);
        one.setScore(one.getScore() + frozen);
        integralRepository.save(one);
    }
}
