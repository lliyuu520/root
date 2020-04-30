package com.lliyuu520.configclient.service.impl;

import com.lliyuu520.api.response.AjaxResult;
import com.lliyuu520.configclient.feign.consumer.ProviderFeign;
import com.lliyuu520.configclient.service.ConsumerService;
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
