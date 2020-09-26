package com.lliyuu520.root.modular.system.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lliyuu520.root.common.controller.BaseController;
import com.lliyuu520.root.core.log.BusinessLog;
import com.lliyuu520.root.core.log.LogModel;
import com.lliyuu520.root.core.log.LogType;
import com.lliyuu520.root.core.utils.PageFactory;
import com.lliyuu520.root.modular.system.dto.SysDeptDTO;
import com.lliyuu520.root.modular.system.entity.SysDept;
import com.lliyuu520.root.modular.system.query.SysDictQuery;
import com.lliyuu520.root.modular.system.service.SysDeptService;
import com.lliyuu520.root.response.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门控制器
 *
 * @author liliangyu
 */
@RestController
@RequestMapping("/sysDept")
@Slf4j
@Api(tags = {"部门"})
@AllArgsConstructor
public class SysDeptController implements BaseController {


    private final SysDeptService sysDeptService;

    /**
     * 字典
     */
    @ApiOperation("/部门列表")
    @BusinessLog(model = LogModel.DEPT, type = LogType.LIST)
    @PostMapping(value = "/list")
    public AjaxResult list(@RequestBody SysDictQuery sysDictQuery) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<>();

        String name = sysDictQuery.getName();
        String eName = sysDictQuery.getEName();
        if (StrUtil.isNotEmpty(eName)) {
            wrapper.like("eName", eName);
        }
        if (StrUtil.isNotEmpty(name)) {
            wrapper.like("name", name);
        }
        wrapper.orderByAsc("order");
        IPage<SysDept> pageVO = new PageFactory<SysDept>().defaultPage();
        pageVO = sysDeptService.page(pageVO, wrapper);
        return AjaxResult.success(pageVO);
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
