package com.lliyuu520.provider.modular.integral.service.cancel;

import com.lliyuu520.provider.modular.integral.mapper.IntegralMapper;
import com.lliyuu520.provider.modular.integral.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("integralServiceCancel")
@Slf4j
public class IntegralServiceCancel implements IntegralService {
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
    public void addIntegral(Long integralId, Integer frozen) {
        log.info("------------------PROVIDER 执行回退开始------------------");

        int i = integralMapper.cancelAddIntegral(integralId, frozen);
        if (1 != i) {
            log.info("------------------PROVIDER 执行回退出错------------------{}",i);
            throw new IllegalStateException("ERROR!");
        }
        log.info("------------------PROVIDER 执行回退结束------------------{}",i);

    }
}
