package com.lliyuu520.haozi.modular.account.controller;


import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.haozi.modular.account.entity.SeataStock;
import com.lliyuu520.haozi.modular.account.service.SeataStockService;
import com.lliyuu520.haozi.vo.InventoryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * 库存controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/seataInventory")
@Slf4j
@RequiredArgsConstructor
public class SeataStockController {


    private final SeataStockService seataStockService;


    /**
     * 根据产品id查询库存
     *
     * @param productId
     * @return
     */
    @GetMapping("/selectByProductId/{productId}")
    public InventoryVO selectByProductId(@PathVariable Long productId) {
        log.info("根据产品ID查询库存productId={}", productId);
        SeataStock seataStock = seataStockService.selectByProductId(productId);
        return BeanUtil.copyProperties(seataStock, InventoryVO.class);


    }

    /**
     * 扣除库存
     *
     * @param productId
     * @param productNum
     * @return
     */
    @PostMapping("/decreaseInventory")
    public void decreaseInventory(@RequestParam("productId") Long productId, @RequestParam("productNum") Integer productNum) {
        log.info("扣除库存productId={},productNum={}", productId, productNum);
        seataStockService.decreaseInventory(productId, productNum);

    }


}
