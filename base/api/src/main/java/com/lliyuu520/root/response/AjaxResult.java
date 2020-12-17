package com.lliyuu520.root.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义返回格式
 *
 * @author lliyuu520* @date 2017年8月29日
 */
@Data
@NoArgsConstructor
public class AjaxResult<T> {
    private Integer code;
    private String message;
    private T data;


    /**
     * 成功
     *
     * @return
     */
    public static <T> AjaxResult<T> success(T o) {
        AjaxResult<T> ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.SUCCESS);
        ajaxResult.setData(o);
        return ajaxResult;
    }

    /**
     * 成功
     *
     * @return
     */
    public static AjaxResult<Void> success() {
        AjaxResult<Void> ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.SUCCESS);
        return ajaxResult;
    }

    private static AjaxResult newInstance() {
        return new AjaxResult();
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
     * 权限异常
     *
     * @return
     */
    public static AjaxResult accessException() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.ACCESS_DENIED_EXCEPTION);
        return ajaxResult;
    }

    /**
     * 权限异常
     *
     * @return
     */
    public static AjaxResult businessException() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.BUSINESS_EXCEPTION);
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
     * 登录失效
     *
     * @return
     */
    public static AjaxResult authExpired() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.AUTH_EXPIRED);
        return ajaxResult;
    }

    /**
     * 登录失效
     *
     * @return
     */
    public static AjaxResult accountNotMatch() {
        AjaxResult ajaxResult = AjaxResult.newInstance();
        ajaxResult.setResult(AjaxResultEnum.ACCOUNT_NOT_MATCH);
        return ajaxResult;
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


}
