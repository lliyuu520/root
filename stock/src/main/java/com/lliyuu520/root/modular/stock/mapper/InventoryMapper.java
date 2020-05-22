package com.lliyuu520.root.modular.stock.mapper;


import com.lliyuu520.root.modular.stock.entity.Inventory;
import org.apache.ibatis.annotations.Param;

public interface InventoryMapper {
    int deleteByPrimaryKey(@Param("id") Long id);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
}