package com.lliyuu520.consumer.service.impl;

import com.lliyuu520.api.response.AjaxResult;
import com.lliyuu520.consumer.feign.consumer.ProviderFeign;
import com.lliyuu520.consumer.service.ConsumerService;
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
