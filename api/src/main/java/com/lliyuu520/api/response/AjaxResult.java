package com.lliyuu520.api.response;

import lombok.Data;

/**
 * 自定义返回格式
 * @author liliangyu
 * @date 2017年8月29日
 */
@Data
public class AjaxResult {
    private Integer code;
    private String message;
    private Object data;

    private AjaxResult() {
    }

    /**
     * 成功
     *
     * @return
     */
    public static AjaxResult success(Object o) {
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.setData(o);
        return ajaxResult;
    }

    /**
     * 成功
     *
     * @return
     */
    public static AjaxResult success() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.SUCCESS);
        return ajaxResult;
    }

    private static AjaxResult newInstance() {
        return new AjaxResult();
    }

    /**
     * 设置枚举
     *
     * @param result
     * @return
     */
    private void setResult(AjaxResultEnum result) {
        this.setCode(result.getKey());
        this.setMessage(result.getValue());
    }

    /**
     * 服务器异常
     *
     * @return
     */
    public static AjaxResult serverException() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.SERVER_EXCEPTION);
        return ajaxResult;
    }

    /**
     * 权限异常
     *
     * @return
     */
    public static AjaxResult accessDeniedException() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.ACCESS_DENIED_EXCEPTION);
        return ajaxResult;
    }

    /**
     * 未登录
     *
     * @return
     */
    public static AjaxResult noAuth() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.NO_AUTH);
        return ajaxResult;
    }
    /**
     * 未登录
     *
     * @return
     */
    public static AjaxResult noData() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.NO_DATA);
        return ajaxResult;
    }
    /**
     * 登录过期
     *
     * @return
     */
    public static AjaxResult authExpired() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.AUTH_EXPIRED);
        return ajaxResult;
    }
    /**
     * 登录过期
     *
     * @return
     */
    public static AjaxResult malformedJwt() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.MALFORMED_JWT);
        return ajaxResult;
    }

    /**
     * 账号密码不匹配
     *
     * @return
     */
    public static AjaxResult accountNotMatch() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.ACCOUNT_NOT_MATCH);
        return ajaxResult;
    }

    /**
     * 新密码老密码重复
     *
     * @return
     */
    public static AjaxResult repeatPassword() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.REPEAT_PASSWORD);
        return ajaxResult;
    }

    /**
     * 新密码老密码重复
     *
     * @return
     */
    public static AjaxResult repeatAccount() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.REPEAT_ACCOUNT);
        return ajaxResult;
    }

    /**
     * 新密码老密码重复
     *
     * @return
     */
    public static AjaxResult repeatRoleName() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.REPEAT_ROLE_NAME);
        return ajaxResult;
    }

    /**
     * 电话号码错误
     *
     * @return
     */
    public static AjaxResult errorPhone() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.ERROR_PHONE);
        return ajaxResult;
    }

    /**
     * 邮箱错误
     *
     * @return
     */
    public static AjaxResult errorMail() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.ERROR_MAIL);
        return ajaxResult;
    }

    /**
     * 账号被锁定
     *
     * @return
     */
    public static AjaxResult lockedAccount() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.LOCKED_ACCOUNT);
        return ajaxResult;
    }
    /**
     * 账号被锁定
     *
     * @return
     */
    public static AjaxResult signatureException() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.SIGNATURE_EXCEPTION);
        return ajaxResult;
    }
}
