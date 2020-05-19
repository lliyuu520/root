package com.lliyuu520.consumer.modular.integral.service.confirm;

import com.lliyuu520.consumer.modular.integral.mapper.IntegralMapper;
import com.lliyuu520.consumer.modular.integral.service.IntegralConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * integralServiceConfirm
 */
@Service("integralServiceConsumerConfirm")
@Slf4j
public class IntegralConsumerServiceConfirm implements IntegralConsumerService {
    @Autowired
    private IntegralMapper integralMapper;

    /**
     * 将冻结移入积分
     *
     * @param integralId
     * @param frozen
     */
    @Override
    @Transactional
    public void reduceIntegral(Long integralId, Integer frozen) {
        log.info("------------------CONSUMER 执行确认开始------------------");

        int i = integralMapper.confirmReduceIntegral(integralId, frozen);
        if (1 != i) {
            log.info("------------------CONSUMER 执行确认出错------------------{}",i);
            throw new IllegalStateException("ERROR!");
        }

        log.info("------------------CONSUMER 执行确认结束------------------{}",i);


    }
}
