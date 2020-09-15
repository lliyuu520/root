package com.lliyuu520.root.modular.consumer.service.impl;

import com.lliyuu520.root.modular.consumer.entity.ConsumerIntegral;
import com.lliyuu520.root.modular.consumer.repository.ConsumerIntegralRepository;
import com.lliyuu520.root.modular.consumer.service.ConsumerIntegralService;
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
public class ConsumerConsumerIntegralServiceImpl implements ConsumerIntegralService {

    private final ConsumerIntegralRepository consumerIntegralRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reduceIntegral(Long integralId, Integer frozen) {
        ConsumerIntegral one = consumerIntegralRepository.getOne(integralId);
        one.setScore(one.getScore() - frozen);
        consumerIntegralRepository.save(one);
    }
}
