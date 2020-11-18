package com.lliyuu520.root.annotation;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * ResponseResultBody
 *
 * @author lliyuu520
 * @since 2020/11/17:下午3:34
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResultBody {
}
