package com.lliyuu520.root.modular.consumer.controller;

import com.lliyuu520.root.feign.IntegralFeign;
import com.lliyuu520.root.modular.consumer.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 积分Controller
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
    public void reduceIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {
        integralService.reduceIntegral(integralId, frozen);
        integralFeign.addIntegral(integralId, frozen);
    }


}
