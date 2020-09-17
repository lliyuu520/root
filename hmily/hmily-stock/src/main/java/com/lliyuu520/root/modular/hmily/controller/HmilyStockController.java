package com.lliyuu520.root.modular.hmily.controller;


import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.root.modular.hmily.entity.HmilyStock;
import com.lliyuu520.root.modular.hmily.service.HmilyStockService;
import com.lliyuu520.root.vo.InventoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * 库存controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/inventory")
@Slf4j
@Api(tags = "{库存}")
@AllArgsConstructor
public class HmilyStockController {


    private final HmilyStockService hmilyStockService;


    /**
     * 根据产品id查询库存
     *
     * @param productId
     * @return
     */
    @GetMapping("/selectByProductId/{productId}")
    @ApiOperation("根据产品id查询库存")
    public InventoryVO selectByProductId(@PathVariable Long productId) {
        log.info("根据产品ID查询库存productId={}", productId);
        HmilyStock hmilyStock = hmilyStockService.selectByProductId(productId);
        return BeanUtil.copyProperties(hmilyStock, InventoryVO.class);


    }

    /**
     * 扣除库存
     *
     * @param productId
     * @param productNum
     * @return
     */
    @PostMapping("/decreaseInventory")
    @ApiOperation("扣除库存")
    public void decreaseInventory(@RequestParam("productId") Long productId, @RequestParam("productNum") Integer productNum) {
        log.info("扣除库存productId={},productNum={}", productId, productNum);
        hmilyStockService.decreaseInventory(productId, productNum);

    }


}
