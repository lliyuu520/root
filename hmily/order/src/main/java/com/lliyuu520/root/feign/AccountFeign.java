package com.lliyuu520.root.feign;

import com.lliyuu520.root.vo.AccountVO;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    AccountVO selectByUserId(@PathVariable("userId") Long userId);

    /**
     * 扣除库存
     *
     * @param userId
     * @param amount
     * @return
     */
    @Hmily
    @PostMapping(value = "/account/decreaseAccount")
    void decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("amount") String amount);
}
