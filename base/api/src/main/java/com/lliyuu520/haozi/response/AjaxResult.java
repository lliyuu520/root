package com.lliyuu520.haozi.response;

import cn.hutool.core.lang.Singleton;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义返回格式
 *
 * @author lliyuu520
 */
@Data
@NoArgsConstructor
public class AjaxResult {
    /**
     * 响应代码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应体
     */
    private Object data;

    /**
     * @return
     */
    private static  AjaxResult getInstance() {
        return Singleton.get(AjaxResult.class);
    }

    /**
     * 操作成功并返回数据
     *
     * @param o
     * @return
     */
    public static AjaxResult success(Object o) {
        final AjaxResult ajaxResult = AjaxResult.setResult(AjaxResultEnum.SUCCESS);
        ajaxResult.setData(o);
        return ajaxResult;

    }

    /**
     * 操作成功
     *
     * @return AjaxResult
     */
    public static AjaxResult success() {
        return AjaxResult.setResult(AjaxResultEnum.SUCCESS);
    }


    /**
     * 服务器异常
     *
     * @return AjaxResult
     */
    public static AjaxResult serverException() {
        return AjaxResult.setResult(AjaxResultEnum.SERVER_EXCEPTION);
    }

    /**
     * 权限异常
     *
     * @return AjaxResult
     */
    public static AjaxResult accessDeniedException() {
        return AjaxResult.setResult(AjaxResultEnum.ACCESS_DENIED_EXCEPTION);
    }


    /**
     * 未登录
     *
     * @return AjaxResult
     */
    public static AjaxResult noAuth() {
        return AjaxResult.setResult(AjaxResultEnum.NO_AUTH);
    }


    /**
     * 账户密码不正确
     *
     * @return AjaxResult
     */
    public static AjaxResult accountNotMatch() {
        return AjaxResult.setResult(AjaxResultEnum.ACCOUNT_NOT_MATCH);
    }

    /**
     * 设置枚举
     *
     * @param result
     * @return
     */
    private static AjaxResult setResult(AjaxResultEnum result) {
        AjaxResult ajaxResult = AjaxResult.getInstance();
        ajaxResult.setCode(result.getKey());
        ajaxResult.setMessage(result.getValue());
        return ajaxResult;
    }


}
