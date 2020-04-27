package com.lliyuu520.configserver.controller;

import com.lliyuu520.api.response.AjaxResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lliyuu520
 */
@RestController
@RequestMapping("/config-client")
public class ConfigClientController {
    @Value("eureka.client.serviceUrl.defaultZone")
    private String defaultZone;

    @GetMapping("/test")
    public AjaxResult test() {

        return AjaxResult.success(defaultZone);
    }
}
