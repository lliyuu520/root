package com.lliyuu520.root.modular.order.controller;


import com.lliyuu520.root.modular.order.dto.PayOrderDTO;
import com.lliyuu520.root.modular.order.service.PaymentService;
import com.lliyuu520.root.response.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 文件上传Controller
 *
 * @author lliyuu520
 * @create 2018/1/22
 */
@RestController
@RequestMapping("/order")
@Slf4j
@Api(tags = {"01.订单"})
@AllArgsConstructor
public class OrderController {


    private final PaymentService paymentService;

    /**
     * 支付订单
     * @param payOrderDTO
     * @return
     */
    @ApiOperation("支付订单")
    @PostMapping("/payOrder")
    public AjaxResult payOrder(@RequestBody PayOrderDTO payOrderDTO) {
        paymentService.payOrder(payOrderDTO);
        return AjaxResult.success();
    }


}
