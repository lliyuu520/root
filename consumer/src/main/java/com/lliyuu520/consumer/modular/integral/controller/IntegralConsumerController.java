package com.lliyuu520.consumer.modular.integral.controller;

import com.lliyuu520.consumer.feign.consumer.IntegralFeign;
import com.lliyuu520.consumer.modular.integral.mapper.IntegralMapper;
import com.lliyuu520.consumer.modular.integral.service.IntegralConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/integral")
@Slf4j
@Compensable(interfaceClass = IntegralConsumerService.class,
        confirmableKey = "integralServiceConsumerConfirm",
        cancellableKey = "integralServiceConsumerCancel")
public class IntegralConsumerController implements IntegralConsumerService {

    @Autowired
    private IntegralFeign integralFeign;
    @Autowired
    private IntegralMapper integralMapper;

    @PostMapping(value = "/transfer")
    @Override
    @Transactional
    public void reduceIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {

        integralFeign.addIntegral(integralId, frozen);

        reduce(integralId, frozen);
    }

    private void reduce(@RequestParam Long integralId, @RequestParam Integer frozen) {
        log.info("------------------CONSUMER 执行尝试开始------------------");
        int i = integralMapper.tryReduceIntegral(integralId, frozen);
        if (1 != i) {
            log.info("------------------CONSUMER 执行尝试出错------------------{}", i);
            throw new IllegalStateException("ERROR!");
        }
        log.info("------------------CONSUMER 执行尝试结束------------------{}", i);
    }


}
