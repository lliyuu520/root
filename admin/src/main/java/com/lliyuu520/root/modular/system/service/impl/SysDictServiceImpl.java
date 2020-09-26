package com.lliyuu520.root.modular.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.common.enums.DeleteStatusEnum;
import com.lliyuu520.root.modular.system.dto.SysDictDTO;
import com.lliyuu520.root.modular.system.entity.SysDict;
import com.lliyuu520.root.modular.system.mapper.SysDictMapper;
import com.lliyuu520.root.modular.system.query.SysDictQuery;
import com.lliyuu520.root.modular.system.service.SysDictService;
import com.lliyuu520.root.modular.system.vo.SysDictNodeVO;
import com.lliyuu520.root.modular.system.vo.SysDictVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@AllArgsConstructor
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
    /**
     * 查询字典
     *
     * @param page
     * @param sysDictQuery
     * @return
     */
    @Override
    public IPage<SysDictVO> selectDict(IPage<SysDict> page, SysDictQuery sysDictQuery) {
        LambdaQueryWrapper<SysDict> query = Wrappers.lambdaQuery(SysDict.class);
        String name = sysDictQuery.getName();
        if(StrUtil.isNotEmpty(name)){
            query.like(SysDict::getName,name);
        }
        this.page(page,query);
        page
        return this.baseMapper.selectSysDict(page, sysDictQuery);
    }

    /**
     * 增加字典
     *
     * @param sysDictDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSysDict(SysDictDTO sysDictDTO) {
        SysDict sysDict = new SysDict();
        BeanUtil.copyProperties(sysDictDTO, sysDict);
        sysDict.setDelFlag(DeleteStatusEnum.NONE.getKey());
        sysDict.setParentId(0L);
        this.save(sysDict);
        Long id = sysDict.getId();
        sysDictDTO.getSysDictDTOList().forEach(m -> {
            SysDict son = new SysDict();
            BeanUtil.copyProperties(m, son);
            son.setParentId(id);
            son.setDelFlag(DeleteStatusEnum.NONE.getKey());
            this.save(son);
        });
    }

    /**
     * 编辑字典
     *
     * @param sysDictDTO
     */
    @Override
    public void editSysDict(SysDictDTO sysDictDTO) {
        SysDict sysDict = new SysDict();
        BeanUtil.copyProperties(sysDictDTO, sysDict);
        sysDict.setDelFlag(DeleteStatusEnum.NONE.getKey());
        sysDict.setParentId(0L);
        this.updateById(sysDict);
        Long id = sysDict.getId();
        this.baseMapper.removeByPid(id);
        sysDictDTO.getSysDictDTOList().forEach(m -> {
            SysDict son = new SysDict();
            BeanUtil.copyProperties(m, son);
            son.setParentId(id);
            son.setDelFlag(DeleteStatusEnum.NONE.getKey());
            this.save(son);
        });
    }

    /**
     * 查询字典详情
     *
     * @param id
     * @return
     */
    @Override
    public SysDictNodeVO selectSysDictNode(String id) {
        SysDict sysDict = this.getById(id);
        SysDictNodeVO sysDictNodeVO = new SysDictNodeVO();

        BeanUtil.copyProperties(sysDict, sysDictNodeVO);
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", id);
        List<SysDict> list = this.list(wrapper);
        List<SysDictNodeVO> collect = list.stream().map(m -> {
            SysDictNodeVO son = new SysDictNodeVO();

            BeanUtil.copyProperties(m, son);
            return son;

        }).collect(Collectors.toList());
        sysDictNodeVO.setChildren(collect);
        return sysDictNodeVO;
    }
}
