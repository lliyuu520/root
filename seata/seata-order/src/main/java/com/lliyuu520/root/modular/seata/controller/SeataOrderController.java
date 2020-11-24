package com.lliyuu520.root.modular.seata.controller;


import com.lliyuu520.root.annotation.ResponseResultBody;
import com.lliyuu520.root.core.exception.BusinessException;
import com.lliyuu520.root.modular.seata.dto.OrderDTO;
import com.lliyuu520.root.modular.seata.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/seataOrder")
@Slf4j
@Api(tags = {"01.订单"})
@RequiredArgsConstructor
@ResponseResultBody
public class SeataOrderController {


    private final PaymentService paymentService;

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @ApiOperation("创建订单")
    @PostMapping("/createSeataOrder")
    public void createOrder(@RequestBody OrderDTO orderDTO) {
        paymentService.createOrder(orderDTO);
    }

    /**
     * 支付订单
     *
     * @param orderId
     * @return
     */
    @ApiOperation("支付订单")
    @PostMapping("/pay")
    public void pay(Long orderId) {
        try {
            paymentService.pay(orderId);
        } catch (BusinessException businessException) {
            businessException.printStackTrace();
            paymentService.payFail(orderId);
            throw businessException;
        }


    }

}
