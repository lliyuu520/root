package com.lliyuu520.provider.modular.integral.service.confirm;

import com.lliyuu520.provider.modular.integral.mapper.IntegralMapper;
import com.lliyuu520.provider.modular.integral.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * integralServiceConfirm
 *
 * @author liliangyu
 */
@Service("integralServiceConfirm")
@Slf4j
public class IntegralServiceConfirm implements IntegralService {
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
    public void addIntegral(Long integralId, Integer frozen) {

        log.info("------------------PROVIDER 执行确认开始------------------");

        int i = integralMapper.confirmAddIntegral(integralId, frozen);
        if (i != 1) {
            log.info("------------------PROVIDER 执行确认出错------------------{}",i);
            throw new IllegalStateException("ERROR!");
        }

        log.info("------------------PROVIDER 执行确认结束------------------{}",i);

    }
}
