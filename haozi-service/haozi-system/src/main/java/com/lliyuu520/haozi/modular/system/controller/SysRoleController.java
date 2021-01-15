package com.lliyuu520.haozi.modular.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.core.log.BusinessLog;
import com.lliyuu520.haozi.core.log.LogModel;
import com.lliyuu520.haozi.core.log.LogType;
import com.lliyuu520.haozi.modular.system.dto.SysRoleDTO;
import com.lliyuu520.haozi.modular.system.dto.SysRolePermissionDTO;
import com.lliyuu520.haozi.modular.system.entity.SysRole;
import com.lliyuu520.haozi.modular.system.query.SysRoleQuery;
import com.lliyuu520.haozi.modular.system.service.SysPermissionService;
import com.lliyuu520.haozi.modular.system.service.SysRoleService;
import com.lliyuu520.haozi.modular.system.vo.SysRoleVO;
import com.lliyuu520.haozi.response.AjaxResult;
import com.lliyuu520.haozi.response.ErrorEnum;
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
@RequiredArgsConstructor
public class SysRoleController implements BaseController {


    private final SysRoleService sysRoleService;

    private final SysPermissionService sysPermissionService;

    /**
     * 用户所有权限
     */
    @PostMapping(value = "/list")
    @BusinessLog(model = LogModel.ROLE, type = LogType.LIST)
    public AjaxResult<PageInfo<SysRoleVO>> list(@RequestBody SysRoleQuery sysRoleQuery) {
        PageHelper.startPage(pageNum(), pageSize());

        final LambdaQueryWrapper<SysRole> query = Wrappers.lambdaQuery(SysRole.class);
        String name = sysRoleQuery.getName();
        if (StrUtil.isNotEmpty(name)) {
            query.like(SysRole::getName, name);
        }
        List<SysRole> list = sysRoleService.list(query);
        final List<SysRoleVO> collect = list.stream().map(m -> BeanUtil.copyProperties(m, SysRoleVO.class)).collect(Collectors.toList());
        final PageInfo<SysRoleVO> of = PageInfo.of(collect);
        return AjaxResult.success(of);
    }

    /**
     * 角色新增
     */
    @BusinessLog(model = LogModel.ROLE, type = LogType.INSERT)
    @PostMapping(value = "/add")
    public AjaxResult<Void> add(@RequestBody SysRoleDTO sysRoleDTO) {
        String name = sysRoleDTO.getName();
        SysRole query = new SysRole();
        query.setName(name);
        SysRole sysRoleDB = sysRoleService.getByName(name);
        if (sysRoleDB != null) {
            //角色名称被使用
            return AjaxResult.failed(ErrorEnum.REPEAT_ACCOUNT);
        }
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(sysRoleDTO, sysRole);
        sysRoleService.save(sysRole);
        return AjaxResult.success();
    }

    /**
     * 角色编辑 角色名称不允许编辑!!!
     */
    @BusinessLog(model = LogModel.ROLE, type = LogType.EDIT)
    @PostMapping(value = "/edit")
    public AjaxResult<Void> edit(@RequestBody SysRoleDTO sysRoleDTO) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(sysRoleDTO, sysRole);
        sysRoleService.updateById(sysRole);
        return AjaxResult.success();
    }

    /**
     * 角色删除
     */
    @BusinessLog(model = LogModel.ROLE, type = LogType.DELETE)
    @PostMapping(value = "/delete")
    public AjaxResult<Void> delete(String id) {
        sysRoleService.removeById(id);
        return AjaxResult.success();
    }

    /**
     * 角色删除
     */
    @BusinessLog(model = LogModel.ROLE, type = LogType.DELETE)
    @PostMapping(value = "/detail")
    public AjaxResult<List<Tree<String>>> detail(Long id) {
        List<Tree<String>> list = sysPermissionService.getMenuNodeByRoleId(id);
        return AjaxResult.success(list);
    }

    /**
     * 角色删除
     */
    @BusinessLog(model = LogModel.ROLE, type = LogType.DELETE)
    @PostMapping(value = "/config")
    public AjaxResult<Void> config(@RequestBody List<SysRolePermissionDTO> list) {
        sysRoleService.config(list);
        return AjaxResult.success();
    }
}
