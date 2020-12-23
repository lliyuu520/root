package com.lliyuu520.haozi.modular.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.core.exception.BusinessException;
import com.lliyuu520.haozi.core.log.BusinessLog;
import com.lliyuu520.haozi.core.log.LogModel;
import com.lliyuu520.haozi.core.log.LogType;
import com.lliyuu520.haozi.core.utils.PasswordUtil;
import com.lliyuu520.haozi.modular.system.dto.ChangePasswordDTO;
import com.lliyuu520.haozi.modular.system.dto.ResetPasswordDTO;
import com.lliyuu520.haozi.modular.system.dto.SysUserDTO;
import com.lliyuu520.haozi.modular.system.entity.SysDept;
import com.lliyuu520.haozi.modular.system.entity.SysUser;
import com.lliyuu520.haozi.modular.system.query.SysUserQuery;
import com.lliyuu520.haozi.modular.system.service.SysDeptService;
import com.lliyuu520.haozi.modular.system.service.SysUserService;
import com.lliyuu520.haozi.modular.system.vo.SysUserVO;
import com.lliyuu520.haozi.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户控制器
 *
 * @author liliangyu
 */
@RestController
@RequestMapping("/sysUser")
@Slf4j
@RequiredArgsConstructor
public class SysUserController implements BaseController {

    private final SysUserService userService;
    private final SysDeptService deptService;

    /**
     * 查询列表`
     */
    @PostMapping(value = "/list")
    @BusinessLog(model = LogModel.USER, type = LogType.LIST)
    public PageInfo<SysUserVO> list(@RequestBody SysUserQuery sysUserQuery) {
        PageHelper.startPage(pageNum(), pageSize());
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        String username = sysUserQuery.getUsername();
        String name = sysUserQuery.getName();
        String eName = sysUserQuery.getEName();
        String phone = sysUserQuery.getPhone();
        if (StrUtil.isNotEmpty(username)) {
            wrapper.like("username", username);
        }
        if (StrUtil.isNotEmpty(eName)) {
            wrapper.like("eName", eName);
        }
        if (StrUtil.isNotEmpty(name)) {
            wrapper.like("name", name);
        }
        if (StrUtil.isNotEmpty(phone)) {
            wrapper.like("phone", phone);
        }
        List<SysUser> sysUsers = userService.list(wrapper);

        List<SysUserVO> collect = sysUsers.stream().map(m -> {

            SysUserVO sysUserVO = new SysUserVO();
            Long deptId = m.getDeptId();
            SysDept sysDept = deptService.getById(deptId);
            if (sysDept != null) {
                sysUserVO.setDeptName(sysDept.getName());
            }
            BeanUtil.copyProperties(m, sysUserVO);
            return sysUserVO;

        }).collect(Collectors.toList());
        PageInfo<SysUserVO> pageInfo = new PageInfo<>(collect);
        return pageInfo;

    }


    /**
     * 修改密码
     */
    @PostMapping(value = "/changePassword")
    @BusinessLog(model = LogModel.USER, type = LogType.CHANGE_PASSWORD)
    public AjaxResult changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {

        // 登录成功会返回Token给用户
        String newPassword = changePasswordDTO.getNewPassword();
        String oldPassword = changePasswordDTO.getOldPassword();
        boolean equals = StrUtil.equals(newPassword, oldPassword);
        if (equals) {
            return AjaxResult.noAuth();
        }
        String encode = PasswordUtil.encode(newPassword);
        userService.changePassword(encode);
        return AjaxResult.success();

    }

    /**
     * 重置密码
     */
    @BusinessLog(model = LogModel.USER, type = LogType.RESET_PASSWORD)
    @PostMapping(value = "/resetPassword")
    public AjaxResult resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        userService.resetPassword(resetPasswordDTO.getUserId());
        return AjaxResult.success();
    }

    /**
     * 解锁用户
     */
    @BusinessLog(model = LogModel.USER, type = LogType.RESET_PASSWORD)
    @PostMapping(value = "/unlockUser")
    public AjaxResult unlockUser(String userId) {
        userService.unLockUser(userId);
        return AjaxResult.success();
    }

    /**
     * 锁定用户
     */
    @BusinessLog(model = LogModel.USER, type = LogType.RESET_PASSWORD)
    @PostMapping(value = "/lockUser")
    public AjaxResult lockUser(String userId) {
        userService.lockUser(userId);
        return AjaxResult.success();
    }

    /**
     * 用户新增
     */
    @BusinessLog(model = LogModel.USER, type = LogType.ADD)
    @PostMapping(value = "/add")
    public void add(@RequestBody SysUserDTO sysUserDTO) {
        String username = sysUserDTO.getUsername();
        SysUser sysUser = userService.loadUserByUsername(username);
        if (sysUser != null) {
            //账号被使用
            throw new BusinessException("用户名已被使用");
        }
        String phone = sysUserDTO.getPhone();
        if (!Validator.isMoney(phone)) {
            throw new BusinessException("电话号码格式不正确");
        }
        userService.addUser(sysUserDTO);

    }

    /**
     * 用户编辑
     */
    @BusinessLog(model = LogModel.USER, type = LogType.EDIT)
    @PostMapping(value = "/edit")
    public AjaxResult edit(@RequestBody SysUserDTO sysUserDTO) {
        String username = sysUserDTO.getUsername();
        String id = sysUserDTO.getId();
        SysUser sysUser = userService.loadUserByUsername(username);
        if (sysUser != null) {
            if (!sysUser.getId().equals(id)) {
                return AjaxResult.noAuth();
            }
        }

        String phone = sysUserDTO.getPhone();
        if (!Validator.isMoney(phone)) {
            return AjaxResult.noAuth();
        }
        userService.editUser(sysUserDTO);

        return AjaxResult.success();
    }

}