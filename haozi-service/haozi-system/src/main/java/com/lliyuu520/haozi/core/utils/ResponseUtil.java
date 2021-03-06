package com.lliyuu520.haozi.core.utils;

import com.alibaba.fastjson.JSON;
import com.lliyuu520.haozi.response.AjaxResult;
import com.lliyuu520.haozi.response.ErrorEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 渲染工具类
 *
 * @author zmdTech
 * @date 2017-08-25 14:13
 */
public class ResponseUtil {

    /**
     * 未传token,未登录
     */
    public static void noAuth(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        AjaxResult<Void> ajaxResult = AjaxResult.failed("noAuth");
        response.getWriter().write(JSON.toJSON(ajaxResult).toString());
    }

    /**
     * token过期
     */
    public static void authExpired(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        AjaxResult ajaxResult = AjaxResult.failed("authExpired");
        response.getWriter().write(JSON.toJSON(ajaxResult).toString());
    }

    /**
     * token过期
     */
    public static void malformedJwt(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        AjaxResult ajaxResult = AjaxResult.failed("malformedJwt");
        response.getWriter().write(JSON.toJSON(ajaxResult).toString());
    }

    /**
     * token过期
     */
    public static void serverException(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        AjaxResult ajaxResult = AjaxResult.failed("serverException");
        response.getWriter().write(JSON.toJSON(ajaxResult).toString());
    }

    /**
     * 密钥错误
     */
    public static void signatureException(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        AjaxResult<Void> ajaxResult = AjaxResult.failed("signatureException");
        response.getWriter().write(JSON.toJSON(ajaxResult).toString());
    }
}
