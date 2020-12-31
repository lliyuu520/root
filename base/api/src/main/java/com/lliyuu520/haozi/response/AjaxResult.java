package com.lliyuu520.haozi.response;

import lombok.Data;

/**
 * 自定义返回格式
 *
 * @author lliyuu520
 */
@Data
public class AjaxResult<T> {
    /**
     * 响应代码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应体
     */
    private T data;

    /**
     * 私有化构造方法
     */
    private AjaxResult() {

    }

    /**
     * 操作成功并返回数据
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> AjaxResult<T> success(T t) {
        final AjaxResult<T> ajaxResult = new AjaxResult<>();
        ajaxResult.setResult(ErrorEnum.SUCCESS);
        ajaxResult.setData(t);
        return ajaxResult;
    }

    /**
     * 操作成功
     *
     * @return AjaxResult
     */
    public static <Void> AjaxResult<Void> success() {
        final AjaxResult<Void> ajaxResult = new AjaxResult<>();
        ajaxResult.setResult(ErrorEnum.SUCCESS);
        return ajaxResult;
    }

    /**
     * 返回失败
     *
     * @param errorEnum
     * @return
     */
    public static AjaxResult<Void> failed(ErrorEnum errorEnum) {
        final AjaxResult<Void> ajaxResult = new AjaxResult<>();
        ajaxResult.setResult(errorEnum);
        return ajaxResult;

    }

    /**
     * 设置枚举
     *
     * @param result
     * @return
     */
    private void setResult(ErrorEnum result) {
        this.setCode(result.getCode());
        this.setMsg(result.getMsg());
    }


}
