package com.lliyuu520.root.modular.consumer.service.impl;

import com.lliyuu520.root.modular.consumer.mapper.IntegralMapper;
import com.lliyuu520.root.modular.consumer.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lliyuu520
 * @date 2020/5/2121:39
 */
@Service
@Slf4j
public class IntegralServiceImpl implements IntegralService {
    @Autowired
    private IntegralMapper integralMapper;
    @Override
    public int reduceIntegral(Long integralId, Integer frozen) {
       return integralMapper.reduceIntegral(integralId, frozen);
    }
}
