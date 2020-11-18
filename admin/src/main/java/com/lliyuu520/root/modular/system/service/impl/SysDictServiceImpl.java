package com.lliyuu520.root.modular.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.common.enums.DelFlagEnum;
import com.lliyuu520.root.modular.system.dto.SysDictDTO;
import com.lliyuu520.root.modular.system.entity.SysDict;
import com.lliyuu520.root.modular.system.mapper.SysDictMapper;
import com.lliyuu520.root.modular.system.query.SysDictQuery;
import com.lliyuu520.root.modular.system.service.SysDictService;
import com.lliyuu520.root.modular.system.vo.SysDictNodeVO;
import com.lliyuu520.root.modular.system.vo.SysDictVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
    /**
     * 查询字典
     *
     * @param sysDictQuery
     * @return
     */
    @Override
    public List<SysDictVO> selectDict(SysDictQuery sysDictQuery) {
        final LambdaQueryWrapper<SysDict> query = Wrappers.lambdaQuery(SysDict.class);
        final String name = sysDictQuery.getName();
        if (StrUtil.isNotEmpty(name)) {
            query.like(SysDict::getName, name);
        }
        final List<SysDict> list = this.list(query);
        List<TreeNode<Long>> nodeList = list.stream().map(sysDict -> {
            final TreeNode<Long> longTreeNode = new TreeNode<>(sysDict.getId(), sysDict.getParentId(), sysDict.getName(), sysDict.getWeight());
            final HashMap<String, Object> extra = new HashMap<>();
            extra.put("code", sysDict.getCode());
            longTreeNode.setExtra(extra);
            return longTreeNode;

        }).collect(Collectors.toList());
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();

        List<Tree<Long>> treeList = TreeUtil.build(nodeList, 0L, treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getWeight());
                    tree.setName(treeNode.getName());
                    tree.putExtra("code", treeNode.getExtra().get("code"));
                });
        final JSONArray objects = JSONArray.parseArray(JSONArray.toJSONString(treeList));
        final List<SysDictVO> sysDictVOS = JSONObject.parseArray(objects.toJSONString(), SysDictVO.class);
        return sysDictVOS;
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
        sysDict.setDelFlag(DelFlagEnum.NONE.getKey());
        sysDict.setParentId(0L);
        this.save(sysDict);
        Long id = sysDict.getId();
        sysDictDTO.getSysDictDTOs().forEach(m -> {
            SysDict son = new SysDict();
            BeanUtil.copyProperties(m, son);
            son.setParentId(id);
            son.setDelFlag(DelFlagEnum.NONE.getKey());
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
        sysDict.setDelFlag(DelFlagEnum.NONE.getKey());
        sysDict.setParentId(0L);
        this.updateById(sysDict);
        Long id = sysDict.getId();
        this.baseMapper.removeByParentId(id);
        sysDictDTO.getSysDictDTOs().forEach(m -> {
            SysDict son = new SysDict();
            BeanUtil.copyProperties(m, son);
            son.setParentId(id);
            son.setDelFlag(DelFlagEnum.NONE.getKey());
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
