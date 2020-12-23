package com.lliyuu520.haozi.core.entrypoint;

import com.alibaba.fastjson.JSON;
import com.lliyuu520.haozi.response.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liliangyu
 * @date 2019/7/30
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(200);
        AjaxResult ajaxResult = AjaxResult.accessDeniedException();
        res.getWriter().write(JSON.toJSON(ajaxResult).toString());

    }

}
