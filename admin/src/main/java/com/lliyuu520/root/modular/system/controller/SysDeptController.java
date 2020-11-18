package com.lliyuu520.root.modular.system.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.root.controller.BaseController;
import com.lliyuu520.root.core.log.BusinessLog;
import com.lliyuu520.root.core.log.LogModel;
import com.lliyuu520.root.core.log.LogType;
import com.lliyuu520.root.modular.system.dto.SysDeptDTO;
import com.lliyuu520.root.modular.system.entity.SysDept;
import com.lliyuu520.root.modular.system.query.SysDictQuery;
import com.lliyuu520.root.modular.system.service.SysDeptService;
import com.lliyuu520.root.response.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = {"部门"})
@RequiredArgsConstructor
public class SysDeptController implements BaseController {


    private final SysDeptService sysDeptService;

    /**
     * 字典
     */
    @ApiOperation("/部门列表")
    @BusinessLog(model = LogModel.DEPT, type = LogType.LIST)
    @PostMapping(value = "/list")
    public PageInfo<SysDept> list(@RequestBody SysDictQuery sysDictQuery) {
        initPage();

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
    @ApiOperation("/部门新增")
    @BusinessLog(model = LogModel.DEPT, type = LogType.ADD)
    @PostMapping(value = "/add")
    public AjaxResult add(@RequestBody SysDeptDTO sysDeptDTO) {

        sysDeptService.saveDept(sysDeptDTO);

        return AjaxResult.success();
    }

    /**
     * 部门编辑
     */
    @ApiOperation("/部门编辑")
    @BusinessLog(model = LogModel.DEPT, type = LogType.EDIT)
    @PostMapping(value = "/edit")
    public AjaxResult edit(@RequestBody SysDeptDTO sysDeptDTO) {

        sysDeptService.editDept(sysDeptDTO);

        return AjaxResult.success();
    }

    /**
     * 部门详情
     */
    @ApiOperation("/部门详情")
    @BusinessLog(model = LogModel.DEPT, type = LogType.ADD)
    @PostMapping(value = "/detail")
    public AjaxResult detail(String id) {

        SysDept sysDept = sysDeptService.getById(id);

        return AjaxResult.success(sysDept);
    }

}
