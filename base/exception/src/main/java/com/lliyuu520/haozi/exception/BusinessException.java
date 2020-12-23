package com.lliyuu520.haozi.exception;

/**
 * 业务异常
 * @author lliyuu520
 * @date 2020/5/2016:37
 */
public class BusinessException extends RuntimeException {
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }
}
