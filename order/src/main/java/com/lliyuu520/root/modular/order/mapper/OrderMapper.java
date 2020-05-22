package com.lliyuu520.root.modular.order.mapper;

import com.lliyuu520.root.modular.order.entiry.Order;

/**
 * @author lliyuu520
 */
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

}
