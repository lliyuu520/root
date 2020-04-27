package com.lliyuu520.configserver.service.impl;

import com.lliyuu520.api.response.AjaxResult;
import com.lliyuu520.configserver.feign.consumer.ProviderFeign;
import com.lliyuu520.configserver.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerImpl implements ConsumerService {

    @Autowired
    private ProviderFeign providerFeign;

    @Override
    public AjaxResult test() {
        return providerFeign.test();
    }
}
