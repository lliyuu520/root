package com.lliyuu520.consumer.modular.integral.service.cancel;

import com.lliyuu520.consumer.modular.integral.mapper.IntegralMapper;
import com.lliyuu520.consumer.modular.integral.service.IntegralConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("integralServiceConsumerCancel")
@Slf4j
public class IntegralConsumerServiceCancel implements IntegralConsumerService {
    @Autowired
    private IntegralMapper integralMapper;

    /**
     * 退回冻结
     *
     * @param integralId
     * @param frozen
     */
    @Override
    @Transactional
    public void reduceIntegral(Long integralId, Integer frozen) {
        log.info("------------------CONSUMER 执行回退开始------------------");

        int i = integralMapper.cancelReduceIntegral(integralId, frozen);
        if (1 != i) {
            log.info("------------------CONSUMER 执行确认出错------------------{}",i);
            throw new IllegalStateException("ERROR!");
        }
        log.info("------------------CONSUMER 执行回退结束------------------{}",i);


    }
}
