package com.lliyuu520.root.modular.system.service;


public interface AuthService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login( String username, String password );

}

