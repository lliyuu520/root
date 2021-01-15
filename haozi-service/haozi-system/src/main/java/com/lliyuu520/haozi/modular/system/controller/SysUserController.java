package com.lliyuu520.haozi.modular.system.controller;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.core.log.BusinessLog;
import com.lliyuu520.haozi.core.log.LogModel;
import com.lliyuu520.haozi.core.log.LogType;
import com.lliyuu520.haozi.core.utils.PasswordUtil;
import com.lliyuu520.haozi.modular.system.dto.ChangePasswordDTO;
import com.lliyuu520.haozi.modular.system.dto.SysUserDTO;
import com.lliyuu520.haozi.modular.system.entity.SysUser;
import com.lliyuu520.haozi.modular.system.query.SysUserQuery;
import com.lliyuu520.haozi.modular.system.service.SysUserService;
import com.lliyuu520.haozi.modular.system.vo.SysUserVO;
import com.lliyuu520.haozi.response.AjaxResult;
import com.lliyuu520.haozi.response.ErrorEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 查询列表`
     */
    @PostMapping(value = "/list")
    @BusinessLog(model = LogModel.USER, type = LogType.LIST)
    public PageInfo<SysUserVO> list(@RequestBody SysUserQuery sysUserQuery) {
        PageHelper.startPage(pageNum(), pageSize());
        final List<SysUserVO> sysUserVOS = this.userService.listByQuery(sysUserQuery);
        return new PageInfo<>(sysUserVOS);

    }


    /**
     * 修改密码
     */
    @PostMapping(value = "/changePassword")
    @BusinessLog(model = LogModel.USER, type = LogType.CHANGE_PASSWORD)
    public AjaxResult<Void> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {

        // 登录成功会返回Token给用户
        String newPassword = changePasswordDTO.getNewPassword();
        String oldPassword = changePasswordDTO.getOldPassword();
        boolean equals = StrUtil.equals(newPassword, oldPassword);
        if (equals) {
            return failed(ErrorEnum.REPEAT_PASSWORD);
        }
        String encode = PasswordUtil.encode(newPassword);
        userService.changePassword(encode);
        return success();

    }

    /**
     * 重置密码
     *
     * @param userId
     * @return
     */
    @BusinessLog(model = LogModel.USER, type = LogType.RESET_PASSWORD)
    @PostMapping(value = "/resetPassword/{userId}")
    public AjaxResult<Void> resetPassword(@PathVariable Long userId) {
        userService.resetPassword(userId);
        return AjaxResult.success();
    }

    /**
     * 解锁用户
     *
     * @param userId
     * @return
     */
    @BusinessLog(model = LogModel.USER, type = LogType.RESET_PASSWORD)
    @PostMapping(value = "/unlockUser/{userId}")
    public AjaxResult<Void> unlockUser(@PathVariable Long userId) {
        userService.unLockUser(userId);
        return AjaxResult.success();
    }

    /**
     * 锁定用户
     *
     * @param userId
     * @return
     */
    @BusinessLog(model = LogModel.USER, type = LogType.RESET_PASSWORD)
    @PostMapping(value = "/lockUser/{userId}")
    public AjaxResult<Void> lockUser(@PathVariable Long userId) {
        userService.lockUser(userId);
        return AjaxResult.success();
    }

    /**
     * 用户新增
     */
    @BusinessLog(model = LogModel.USER, type = LogType.INSERT)
    @PostMapping(value = "/add")
    public AjaxResult<Void> add(@RequestBody SysUserDTO sysUserDTO) {
        String username = sysUserDTO.getUsername();
        String phone = sysUserDTO.getPhone();
        if (!Validator.isMobile(phone)) {
            return failed("电话号码格式错误!");
        }
        SysUser sysUser = userService.loadUserByUsername(username);
        if (sysUser != null) {
            return failed(ErrorEnum.REPEAT_ACCOUNT);
        }
        userService.addUser(sysUserDTO);
        return success();
    }

    /**
     * 用户编辑
     */
    @BusinessLog(model = LogModel.USER, type = LogType.EDIT)
    @PostMapping(value = "/edit")
    public AjaxResult<Void> edit(@RequestBody SysUserDTO sysUserDTO) {
        String username = sysUserDTO.getUsername();
        Long id = sysUserDTO.getId();
        SysUser sysUser = userService.loadUserByUsername(username);
        if (sysUser != null) {
            if (!sysUser.getId().equals(id)) {
                return AjaxResult.failed(ErrorEnum.REPEAT_ACCOUNT);
            }
        }

        String phone = sysUserDTO.getPhone();
        if (!Validator.isMobile(phone)) {
            return failed("电话号码格式错误!");
        }
        userService.editUser(sysUserDTO);

        return AjaxResult.success();
    }

}
