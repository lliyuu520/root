package com.lliyuu520.configclient.controller;

import com.lliyuu520.api.response.AjaxResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lliyuu520
 */
@RestController
@RequestMapping("/config-client")
@RefreshScope
public class ConfigClientController {
    @Value("${username}")
    private String username;

    @GetMapping("/test")
    public AjaxResult test() {

        return AjaxResult.success(username);
    }
}
