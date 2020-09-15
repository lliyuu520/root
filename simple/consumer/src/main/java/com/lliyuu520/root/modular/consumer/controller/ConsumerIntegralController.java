package com.lliyuu520.root.modular.consumer.controller;

import com.lliyuu520.root.feign.ProviderIntegralFeign;
import com.lliyuu520.root.modular.consumer.service.ConsumerIntegralService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@AllArgsConstructor
public class ConsumerIntegralController {


    private final ProviderIntegralFeign providerIntegralFeign;

    private final ConsumerIntegralService consumerIntegralService;

    @PostMapping(value = "/transfer")
    public void reduceIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {
        consumerIntegralService.reduceIntegral(integralId, frozen);
        providerIntegralFeign.addIntegral(integralId, frozen);
    }


}
