package com.lliyuu520.haozi.modular.system.service;

/**
 * 授权接口
 * @author liliangyu
 */
public interface AuthService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login( String username, String password );

}

