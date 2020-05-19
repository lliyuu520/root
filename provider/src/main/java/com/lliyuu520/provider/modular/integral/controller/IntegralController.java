package com.lliyuu520.provider.modular.integral.controller;

import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.api.modular.integral.Integral;
import com.lliyuu520.api.response.AjaxResult;
import com.lliyuu520.provider.modular.integral.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private IntegralService integralService;

    @GetMapping(value = "/{id}")
    public AjaxResult test(@PathVariable("id") Integer id) {
        Integral integral = integralService.getById(id);
        return AjaxResult.success(integral);
    }

    @GetMapping(value = "/add")
    public AjaxResult test(Long integralId ,Integer score) {
        Integral integral = integralService.getById(integralId);
        if(BeanUtil.isEmpty(integral)){
            return AjaxResult.noAuth();
        }
        Integer score0 = integral.getScore();
        score0=score0+score;
        integral.setScore(score0);
        integralService.updateById(integral);
        return AjaxResult.success();
    }

}
