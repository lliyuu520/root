package com.lliyuu520.provider.feign.provider;

import com.lliyuu520.api.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/provider")
@Slf4j
public class ProviderController {

    @GetMapping(value = "/test")
    public AjaxResult test() {

        return AjaxResult.success();
    }

}
