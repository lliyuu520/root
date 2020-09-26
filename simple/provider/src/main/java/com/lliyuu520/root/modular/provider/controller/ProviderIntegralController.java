package com.lliyuu520.root.modular.provider.controller;

import cn.hutool.core.util.StrUtil;
import com.lliyuu520.root.modular.provider.service.ProviderIntegralService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/provider-integral")
@Slf4j
@AllArgsConstructor
public class ProviderIntegralController {


    private final ProviderIntegralService providerIntegralService;


    /**
     * try 写入冻结 加
     *
     * @param integralId
     * @param frozen
     * @return
     */

    @PostMapping(value = "/add")
    @Transactional(rollbackFor = Exception.class)
    public void addIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {
        providerIntegralService.addProviderIntegral(integralId, frozen);
    }


}
