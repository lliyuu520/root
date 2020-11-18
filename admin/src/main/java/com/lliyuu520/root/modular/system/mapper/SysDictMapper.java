package com.lliyuu520.root.modular.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lliyuu520.root.modular.system.entity.SysDict;
import com.lliyuu520.root.modular.system.query.SysDictQuery;
import com.lliyuu520.root.modular.system.vo.SysDictVO;
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
