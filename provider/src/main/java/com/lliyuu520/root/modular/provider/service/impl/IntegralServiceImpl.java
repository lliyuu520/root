package com.lliyuu520.root.modular.provider.service.impl;

import com.lliyuu520.root.core.exception.AccessException;
import com.lliyuu520.root.modular.provider.mapper.IntegralMapper;
import com.lliyuu520.root.modular.provider.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * integralServiceConfirm
 *
 * @author liliangyu
 */
@Service
@Slf4j
public class IntegralServiceImpl implements IntegralService {
    @Autowired
    private IntegralMapper integralMapper;

    /**
     * 将冻结移入积分
     *
     * @param integralId
     * @param frozen
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addIntegral(Long integralId, Integer frozen) {

        int i = integralMapper.addIntegral(integralId, frozen);
        if (1 != i) {
            throw new AccessException("ERROR!");
        }


    }
}
