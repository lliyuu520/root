package com.lliyuu520.haozi.modular.system.dto;

import lombok.Data;

/**
 * @author liliangyu
 * @description 修改用户密码
 * @date 2019-07-31
 */
@Data
public class ChangePasswordDTO {
    /**
     * 原密码
     */
    private String oldPassword;
    /**
     * 新密码
     */
    private String newPassword;
}
