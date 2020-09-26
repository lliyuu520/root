package com.lliyuu520.root.modular.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.root.modular.system.dto.SysDictDTO;
import com.lliyuu520.root.modular.system.entity.SysDict;
import com.lliyuu520.root.modular.system.query.SysDictQuery;
import com.lliyuu520.root.modular.system.vo.SysDictNodeVO;
import com.lliyuu520.root.modular.system.vo.SysDictVO;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
public interface SysDictService extends IService<SysDict> {
    /**
     * 查询字典
     * @param page
     * @param sysDictQuery
     * @return
     */
    IPage<SysDictVO> selectDict(IPage<SysDict> page, SysDictQuery sysDictQuery);

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
    SysDictNodeVO selectSysDictNode(String id);
}
