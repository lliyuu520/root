package com.lliyuu520.haozi.modular.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.modular.system.dto.SysDictDTO;
import com.lliyuu520.haozi.modular.system.entity.SysDict;
import com.lliyuu520.haozi.modular.system.query.SysDictQuery;
import com.lliyuu520.haozi.modular.system.vo.SysDictNodeVO;
import com.lliyuu520.haozi.modular.system.vo.SysDictVO;

import java.util.List;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
public interface SysDictService extends IService<SysDict> {
    /**
     * 查询字典
     * @param sysDictQuery
     * @return
     */
    List<SysDictVO> selectDict(SysDictQuery sysDictQuery);

    /**
     * 增加字典
     * @param sysDictDTO
     */
    void addSysDict(SysDictDTO sysDictDTO);


    /**
     * 编辑字典
     * @param sysDictDTO
     */
    void editSysDict(SysDictDTO sysDictDTO);

    /**
     * 查询字典详情
     * @param id
     * @return
     */
    SysDictNodeVO selectSysDictNode(Long id);
}
