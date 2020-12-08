package com.lliyuu520.root.controller;

import cn.hutool.core.util.StrUtil;
import com.lliyuu520.root.utils.IpUtil;

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

}
