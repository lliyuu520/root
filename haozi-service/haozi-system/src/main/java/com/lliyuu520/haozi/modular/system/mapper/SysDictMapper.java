package com.lliyuu520.haozi.modular.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lliyuu520.haozi.modular.system.entity.SysDict;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 字典
 * @author liliangyu
 */
@Repository
public interface SysDictMapper extends BaseMapper<SysDict> {


    /**
     * 根据pid删除
     * @param parentId
     */
    void removeByParentId(@Param("parentId") Long parentId);
}
