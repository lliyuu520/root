package com.lliyuu520.consumer.modular.integraldetail.controller;

import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.api.modular.integraldetail.IntegralDetail;
import com.lliyuu520.api.response.AjaxResult;
import com.lliyuu520.consumer.feign.consumer.IntegralFeign;
import com.lliyuu520.consumer.modular.integraldetail.IntegralDetailDTO;
import com.lliyuu520.consumer.modular.integraldetail.service.IntegralDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/integral-detail")
@Slf4j
public class IntegralDetailController {
    @Autowired
    private IntegralDetailService integralDetailService;
    @Autowired
    private IntegralFeign integralFeign;

    @PostMapping(value = "/add")
    public AjaxResult consumer(@RequestBody IntegralDetailDTO integralDetailDTO) {

        Long integralId = integralDetailDTO.getIntegralId();
        IntegralDetail integralDetail = new IntegralDetail();
        BeanUtil.copyProperties(integralDetailDTO, integralDetail);
        integralDetailService.save(integralDetail);
        integralFeign.add(integralId, integralDetail.getScore());
        return AjaxResult.success();
    }


}
