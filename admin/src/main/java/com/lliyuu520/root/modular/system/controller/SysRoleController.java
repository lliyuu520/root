package com.lliyuu520.root.modular.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.root.annotation.ResponseResultBody;
import com.lliyuu520.root.controller.BaseController;
import com.lliyuu520.root.core.log.BusinessLog;
import com.lliyuu520.root.core.log.LogModel;
import com.lliyuu520.root.core.log.LogType;
import com.lliyuu520.root.modular.system.dto.SysRoleDTO;
import com.lliyuu520.root.modular.system.dto.SysRolePermissionDTO;
import com.lliyuu520.root.modular.system.entity.SysRole;
import com.lliyuu520.root.modular.system.query.SysRoleQuery;
import com.lliyuu520.root.modular.system.service.SysPermissionService;
import com.lliyuu520.root.modular.system.service.SysRoleService;
import com.lliyuu520.root.modular.system.vo.SysRoleVO;
import com.lliyuu520.root.response.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色控制器
 *
 * @author liliangyu
 */
@RestController
@RequestMapping("/sysRole")
@Api(tags = {"角色"})
@ResponseResultBody
@RequiredArgsConstructor
public class SysRoleController implements BaseController {


    private final SysRoleService sysRoleService;

    private final SysPermissionService sysPermissionService;

    /**
     * 用户所有权限
     */
    @ApiOperation("角色列表")
    @PostMapping(value = "/list")
    @BusinessLog(model = LogModel.ROLE, type = LogType.LIST)
    public PageInfo<SysRoleVO> list(@RequestBody SysRoleQuery sysRoleQuery) {
        initPage();
        final LambdaQueryWrapper<SysRole> query = Wrappers.lambdaQuery(SysRole.class);
        String name = sysRoleQuery.getName();
        if (StrUtil.isNotEmpty(name)) {
            query.like(SysRole::getName, name);
        }
        List<SysRole> list = sysRoleService.list(query);
        final List<SysRoleVO> collect = list.stream().map(m -> BeanUtil.copyProperties(m, SysRoleVO.class)).collect(Collectors.toList());
        return PageInfo.of(collect);
    }

    /**
     * 角色新增
     */
    @ApiOperation("角色新增")
    @BusinessLog(model = LogModel.ROLE, type = LogType.ADD)
    @PostMapping(value = "/add")
    public AjaxResult add(@RequestBody SysRoleDTO sysRoleDTO) {
        String name = sysRoleDTO.getName();
        SysRole query = new SysRole();
        query.setName(name);
        SysRole sysRoleDB = sysRoleService.getByName(name);
        if (sysRoleDB != null) {
            //角色名称被使用
            return AjaxResult.noAuth();
        }
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(sysRoleDTO, sysRole);
        sysRoleService.save(sysRole);
        return AjaxResult.success();
    }

    /**
     * 角色编辑 角色名称不允许编辑!!!
     */
    @ApiOperation("角色编辑")
    @BusinessLog(model = LogModel.ROLE, type = LogType.EDIT)
    @PostMapping(value = "/edit")
    public AjaxResult edit(@RequestBody SysRoleDTO sysRoleDTO) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(sysRoleDTO, sysRole);
        sysRoleService.updateById(sysRole);
        return AjaxResult.success();
    }

    /**
     * 角色删除
     */
    @ApiOperation("角色删除")
    @BusinessLog(model = LogModel.ROLE, type = LogType.DELETE)
    @PostMapping(value = "/delete")
    public AjaxResult delete(String id) {
        sysRoleService.removeById(id);
        return AjaxResult.success();
    }

    /**
     * 角色删除
     */
    @ApiOperation("角色详情")
    @BusinessLog(model = LogModel.ROLE, type = LogType.DELETE)
    @PostMapping(value = "/detail")
    public AjaxResult detail(Long id) {
        List<Tree<String>> list = sysPermissionService.getMenuNodeByRoleId(id);
        return AjaxResult.success(list);
    }

    /**
     * 角色删除
     */
    @ApiOperation("角色配置")
    @BusinessLog(model = LogModel.ROLE, type = LogType.DELETE)
    @PostMapping(value = "/config")
    public AjaxResult config(@RequestBody List<SysRolePermissionDTO> list) {
        sysRoleService.config(list);
        return AjaxResult.success();
    }
}
