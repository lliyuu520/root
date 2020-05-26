package com.lliyuu520.root.feign;

import com.lliyuu520.root.modular.stock.vo.InventoryVO;
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
@FeignClient(value = "stock")
public interface InventoryFeign {
    /**
     * 查询库存接口
     * @param productId
     * @return
     */
    @GetMapping(value = "/inventory/selectByProductId/{productId}")
    InventoryVO selectByProductId(@PathVariable("productId") Long productId);

    /**
     * 扣除库存
     * @param productId
     * @param productNum
     * @return
     */
    @Hmily
    @PostMapping(value = "/inventory/decreaseInventory")
    void decreaseInventory(@RequestParam("productId")Long productId,@RequestParam("productNum")Integer productNum);
}
