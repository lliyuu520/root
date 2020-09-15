package com.lliyuu520.root.modular.orderform.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户购买商品
 * @author lliyuu520
 * @date 2020/5/2314:30
 */
@Data
@ApiModel("支付订单")
public class OrderDTO implements Serializable {
    /**
     * 用户ID 人
     */
    private Long userId;
    /**
     * 产品ID 物
     */
    private Long productId;
    /**
     * 产品数量 数
     */
    private Integer productNum;

}
