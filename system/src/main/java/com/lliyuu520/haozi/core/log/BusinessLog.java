package com.lliyuu520.haozi.core.log;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @author csy
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BusinessLog {
    /**
     * 模块
     */
    LogModel model() default LogModel.OTHER;

    /**
     * 功能
     */
    LogType type() default LogType.OTHER;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;
}
