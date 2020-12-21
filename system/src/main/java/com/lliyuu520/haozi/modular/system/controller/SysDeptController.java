package com.lliyuu520.haozi.modular.system.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.core.log.BusinessLog;
import com.lliyuu520.haozi.core.log.LogModel;
import com.lliyuu520.haozi.core.log.LogType;
import com.lliyuu520.haozi.modular.system.dto.SysDeptDTO;
import com.lliyuu520.haozi.modular.system.entity.SysDept;
import com.lliyuu520.haozi.modular.system.query.SysDictQuery;
import com.lliyuu520.haozi.modular.system.service.SysDeptService;
import com.lliyuu520.haozi.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门控制器
 *
 * @author liliangyu
 */
@RestController
@RequestMapping("/sys-dept")
@Slf4j
@RequiredArgsConstructor
public class SysDeptController implements BaseController {


    private final SysDeptService sysDeptService;

    /**
     * 字典
     */
    @PostMapping(value = "/list")
    public PageInfo<SysDept> list(@RequestBody SysDictQuery sysDictQuery) {
        PageHelper.startPage(pageNum(), pageSize());

        QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
        String name = sysDictQuery.getName();
        if (StrUtil.isNotEmpty(name)) {
            wrapper.like("name", name);
        }
        wrapper.orderByAsc("order");
        List<SysDept> list = sysDeptService.list(wrapper);
        PageInfo<SysDept> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 部门新增
     */
    @PostMapping(value = "/add")
    public AjaxResult add(@RequestBody SysDeptDTO sysDeptDTO) {

        sysDeptService.saveDept(sysDeptDTO);

        return AjaxResult.success();
    }

    /**
     * 部门编辑
     */
    @BusinessLog(model = LogModel.DEPT, type = LogType.EDIT)
    @PostMapping(value = "/edit")
    public AjaxResult edit(@RequestBody SysDeptDTO sysDeptDTO) {

        sysDeptService.editDept(sysDeptDTO);

        return AjaxResult.success();
    }

    /**
     * 部门详情
     */
    @BusinessLog(model = LogModel.DEPT, type = LogType.ADD)
    @PostMapping(value = "/detail")
    public AjaxResult detail(String id) {

        SysDept sysDept = sysDeptService.getById(id);

        return AjaxResult.success(sysDept);
    }

}
