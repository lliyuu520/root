package com.lliyuu520.root.modular.seata.controller;


import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.root.modular.seata.entity.SeataInventory;
import com.lliyuu520.root.modular.seata.service.SeataInventoryService;
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
public class SeataInventoryController {


    private final SeataInventoryService seataInventoryService;


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
        SeataInventory seataInventory = seataInventoryService.selectByProductId(productId);
        return BeanUtil.copyProperties(seataInventory, InventoryVO.class);


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
        seataInventoryService.decreaseInventory(productId, productNum);

    }


}
