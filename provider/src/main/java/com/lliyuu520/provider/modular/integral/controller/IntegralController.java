package com.lliyuu520.provider.modular.integral.controller;

import com.lliyuu520.provider.modular.integral.mapper.IntegralMapper;
import com.lliyuu520.provider.modular.integral.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
@Compensable(interfaceClass = IntegralService.class, confirmableKey = "integralServiceConfirm", cancellableKey = "integralServiceCancel")
public class IntegralController implements IntegralService {

    @Autowired
    private IntegralMapper integralMapper;

    /**
     * try 写入冻结 加
     *
     * @param integralId
     * @param frozen
     * @return
     */
    @Override
    @GetMapping(value = "/add")
    @Transactional
    public void addIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {

        log.info("------------------PROVIDER 执行尝试开始------------------");
        System.out.println("integralId=" + integralId);
        System.out.println("frozen=" + frozen);

        int i = integralMapper.tryAddIntegral(integralId, frozen);
        if (1 != i) {
            log.info("------------------PROVIDER 执行尝试出错------------------{}",i);
            throw new IllegalStateException("ERROR!");
        }

        log.info("------------------PROVIDER 执行尝试结束------------------{}",i);

        log.info("成功接受转账 integralId={} frozen={}", integralId, frozen);

    }


}
