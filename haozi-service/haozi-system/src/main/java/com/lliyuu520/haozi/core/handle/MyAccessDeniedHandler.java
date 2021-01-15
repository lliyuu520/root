package com.lliyuu520.haozi.core.handle;

import com.alibaba.fastjson.JSON;
import com.lliyuu520.haozi.response.AjaxResult;
import com.lliyuu520.haozi.response.ErrorEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liliangyu
 * @date 2019-08-13
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(200);
        AjaxResult<Void> ajaxResult = AjaxResult.failed(ErrorEnum.ACCESS_DENIED_EXCEPTION);
        httpServletResponse.getWriter().write(JSON.toJSON(ajaxResult).toString());
    }
}
