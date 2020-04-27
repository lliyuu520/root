package com.lliyuu520.configserver.controller;

import com.lliyuu520.api.response.AjaxResult;
import com.lliyuu520.configserver.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping(value = "/test")
    public AjaxResult consumer() {
        AjaxResult test = consumerService.test();
        return test;
    }


}
