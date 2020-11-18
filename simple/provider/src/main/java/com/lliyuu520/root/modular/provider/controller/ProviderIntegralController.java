package com.lliyuu520.root.modular.provider.controller;

import com.github.pagehelper.PageInfo;
import com.lliyuu520.root.controller.BaseController;
import com.lliyuu520.root.modular.provider.entity.ProviderIntegral;
import com.lliyuu520.root.modular.provider.service.ProviderIntegralService;
import com.lliyuu520.root.query.BaseQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/provider-integral")
@Slf4j
@RequiredArgsConstructor
public class ProviderIntegralController implements BaseController {


    private final ProviderIntegralService providerIntegralService;


    /**
     * try 写入冻结 加
     *
     * @param integralId
     * @param frozen
     * @return
     */

    @PostMapping(value = "/add")
    public void addIntegral(@RequestParam Long integralId, @RequestParam Integer frozen) {
        providerIntegralService.addProviderIntegral(integralId, frozen);
    }

    /**
     * try 写入冻结 加
     *
     * @return
     */

    @PostMapping(value = "/list")
    public PageInfo<ProviderIntegral> list(BaseQuery baseQuery) {
        initPage();
        List<ProviderIntegral> list = this.providerIntegralService.list();
        PageInfo<ProviderIntegral> page = new PageInfo<>(list);
        return page;
    }


}
