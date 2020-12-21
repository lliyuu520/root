package com.lliyuu520.haozi.feign;

import com.lliyuu520.haozi.vo.AccountVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lliyuu520
 * @date 2020/5/2219:13
 */
@FeignClient(value = "seata-account")
public interface SeataAccountFeign {
    /**
     * 查询库存接口
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/seataAccount/selectByUserId/{userId}")
    AccountVO selectByUserId(@PathVariable("userId") Long userId);

    /**
     * 扣除库存
     *
     * @param userId
     * @param amount
     * @return
     */
    @PostMapping(value = "/seataAccount/decreaseAccount")
    void decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("amount") String amount);
}
