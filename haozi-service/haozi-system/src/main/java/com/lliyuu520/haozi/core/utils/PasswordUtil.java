package com.lliyuu520.haozi.core.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * 密码工具类
 * @author liliangyu
 * @date 2019-08-05
 */
public class PasswordUtil {
    /**
     * 生成密码
     *
     * @param originalPassword
     * @return
     */
    public static String encode(String originalPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(originalPassword);
    }

    /**
     * 匹配密码
     *
     * @param originalPassword
     * @param encodePassword
     * @return
     */
    public static Boolean match(String originalPassword, String encodePassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(originalPassword, encodePassword);
    }
}
