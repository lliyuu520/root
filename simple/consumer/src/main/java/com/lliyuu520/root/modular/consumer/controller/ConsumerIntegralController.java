package com.lliyuu520.root.modular.consumer.controller;

import com.lliyuu520.root.controller.BaseController;
import com.lliyuu520.root.modular.consumer.service.ConsumerIntegralService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * ConsumerIntegralController
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/integral")
@Slf4j
@RequiredArgsConstructor
public class ConsumerIntegralController implements BaseController {


    private final ConsumerIntegralService consumerIntegralService;

    @PostMapping(value = "/transfer")
    public void reduceIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {
        consumerIntegralService.reduceIntegral(integralId, frozen);
    }


}
