//package com.lliyuu520.root.core.handle;
//
//import com.lliyuu520.root.annotation.ResponseResultBody;
//import com.lliyuu520.root.core.exception.BusinessException;
//import com.lliyuu520.root.response.AjaxResult;
//import io.jsonwebtoken.ExpiredJwtException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.InternalAuthenticationServiceException;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
///**
// * 自定义异常
// *
// * @author zmdTech
// * @date 2019年08月12日
// */
//@RestControllerAdvice
//@Order(-1)
//@Slf4j
//@ResponseResultBody
//public class BaseControllerExceptionHandler extends ResponseEntityExceptionHandler {
//
//
//    /**
//     * 账户被锁定
//     */
//    @ExceptionHandler(LockedException.class)
//    public AjaxResult ajaxResult(LockedException e) {
//        log.error(e.getMessage(), e);
//        return AjaxResult.noAuth();
//    }
//
//    /**
//     * 帐号密码不匹配
//     */
//    @ExceptionHandler(BadCredentialsException.class)
//    public AjaxResult ajaxResult(BadCredentialsException e) {
//        log.error(e.getMessage(), e);
//        return AjaxResult.accountNotMatch();
//    }
//
//    /**
//     * 登录过期
//     */
//    @ExceptionHandler(ExpiredJwtException.class)
//    public AjaxResult ajaxResult(ExpiredJwtException e) {
//        log.error(e.getMessage(), e);
//        return AjaxResult.noAuth();
//    }
//
//    /**
//     * 权限异常
//     */
//    @ExceptionHandler(AccessDeniedException.class)
//    public AjaxResult ajaxResult(AccessDeniedException e) {
//        log.error(e.getMessage(), e);
//        return AjaxResult.accessDeniedException();
//    }
//
//    /**
//     * 内部认证服务异常
//     */
//    @ExceptionHandler(InternalAuthenticationServiceException.class)
//    public AjaxResult ajaxResult(InternalAuthenticationServiceException e) {
//        log.error(e.getLocalizedMessage(), e);
//        return AjaxResult.accountNotMatch();
//    }
//
//    /**
//     * 已知异常(放最后)
//     */
//    @ExceptionHandler(BusinessException.class)
//    public AjaxResult ajaxResult(BusinessException e) {
//        log.error(e.getMessage(), e);
//        return AjaxResult.businessException();
//    }
//
//    /**
//     * 拦截未知的运行时异常(放最后)
//     */
//    @ExceptionHandler(RuntimeException.class)
//    public AjaxResult ajaxResult(RuntimeException e) {
//        log.error(e.getMessage(), e);
//        return AjaxResult.serverException();
//    }
//
//}
