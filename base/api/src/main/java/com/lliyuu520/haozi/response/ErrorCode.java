package com.lliyuu520.haozi.response;

/**
 * ErrorCode
 *
 * @author lliyuu520
 * @since 2020/12/31:11:34
 */
public interface ErrorCode {

    /**
     * 200:成功
     */
    Integer getCode();

    /**
     * 错误描述
     */
    String getMsg();
}
