package com.lliyuu520.root.modular.consumer.service.impl;

import com.lliyuu520.root.modular.consumer.repository.IntegralRepository;
import com.lliyuu520.root.modular.consumer.service.IntegralService;
import com.lliyuu520.root.modular.integral.entity.Integral;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lliyuu520
 * @date 2020/5/2121:39
 */
@Service
@Slf4j
@AllArgsConstructor
public class IntegralServiceImpl implements IntegralService {

    private final IntegralRepository integralRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reduceIntegral(Long integralId, Integer frozen) {
        Integral integral = integralRepository.getOne(integralId);
        integral.setScore(integral.getScore() - frozen);
        integralRepository.save(integral);
    }
}
