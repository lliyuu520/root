package com.lliyuu520.haozi.controller;

import cn.hutool.core.util.StrUtil;
import com.lliyuu520.haozi.response.AjaxResult;
import com.lliyuu520.haozi.response.ErrorEnum;
import com.lliyuu520.haozi.utils.IpUtil;

import javax.servlet.http.HttpServletRequest;


/**
 * BaseController
 *
 * @author lliyuu520
 * @since 2020/11/10:14:07
 */
public interface BaseController {


    /**
     * 默认分页参数
     *
     * @return
     */
    default int pageNum() {
        final HttpServletRequest request = IpUtil.getRequest();
        String pageNum = request.getParameter("pageNum");
        int i = 1;
        if (StrUtil.isNotEmpty(pageNum)) {
            i = Integer.parseInt(pageNum);
        }
        return i;

    }

    /**
     * 默认分页参数
     *
     * @return
     */
    default int pageSize() {
        final HttpServletRequest request = IpUtil.getRequest();
        String pageSize = request.getParameter("pageSize");
        int j = 10;
        if (StrUtil.isNotEmpty(pageSize)) {
            j = Integer.parseInt(pageSize);
        }
        return j;

    }

    /**
     * 返回成功 不带数据
     * @return
     */
   default AjaxResult<Void> success(){
        return  AjaxResult.success();
    }

    /**
     * 返回成功 带数据
     * @param t
     * @param <T>
     * @return
     */
    default <T> AjaxResult<T> success(T t){
        return  AjaxResult.success(t);
    }

    /**
     * 返回错误 不带参数
     * @param errorEnum
     * @return
     */
    default AjaxResult<Void> failed(ErrorEnum errorEnum){
        return  AjaxResult.failed(errorEnum);
    }
    /**
     * 返回错误 不带参数
     * @param msg
     * @return
     */
    default AjaxResult<Void> failed(String msg){
        return  AjaxResult.failed(msg);
    }



}
