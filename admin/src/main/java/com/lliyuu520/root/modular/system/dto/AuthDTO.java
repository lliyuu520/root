package com.lliyuu520.root.modular.system.dto;

import lombok.Data;

/**
 * 授权登录dto
 * @author liliangyu
 * @date 2019-08-02
 */
@Data
public class AuthDTO {
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
