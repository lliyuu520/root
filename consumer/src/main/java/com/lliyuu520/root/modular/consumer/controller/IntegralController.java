package com.lliyuu520.root.modular.consumer.controller;

import com.lliyuu520.root.core.exception.AccessException;
import com.lliyuu520.root.feign.IntegralFeign;
import com.lliyuu520.root.modular.consumer.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
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
public class IntegralController {

    @Autowired
    private IntegralFeign integralFeign;
    @Autowired
    private IntegralService integralService;

    @PostMapping(value = "/transfer")
    @Transactional(rollbackFor = Exception.class)
    public void reduceIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {

        integralFeign.addIntegral(integralId, frozen);

        reduce(integralId, frozen);
    }

    private void reduce(@RequestParam Long integralId, @RequestParam Integer frozen) {
        int i = integralService.reduceIntegral(integralId, frozen);
        if (1 != i) {
            throw new AccessException("ERROR!");
        }
    }


}
