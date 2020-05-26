package com.lliyuu520.root.feign;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author lliyuu520
 * @date 2020/5/2219:13
 */
@FeignClient(value = "account")
public interface AccountFeign {
    /**
     * 查询库存接口
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/account/selectByUserId/{userId}")
    BigDecimal selectByUserId(@PathVariable("userId") String userId);

    /**
     * 扣除库存
     *
     * @param userId
     * @param amount
     * @return
     */
    @Hmily
    @PostMapping(value = "/account/decreaseAccount")
    void decreaseAccount(@RequestParam("userId") String userId, @RequestParam("amount") String amount);
}
