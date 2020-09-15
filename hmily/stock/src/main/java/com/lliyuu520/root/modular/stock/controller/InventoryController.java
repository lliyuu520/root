package com.lliyuu520.root.modular.stock.controller;


import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.root.modular.stock.entity.Inventory;
import com.lliyuu520.root.modular.stock.service.InventoryService;
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
public class InventoryController {


    private final InventoryService inventoryService;


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
        Inventory inventory = inventoryService.selectByProductId(productId);
        return BeanUtil.copyProperties(inventory, InventoryVO.class);


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
        inventoryService.decreaseInventory(productId, productNum);

    }


}
