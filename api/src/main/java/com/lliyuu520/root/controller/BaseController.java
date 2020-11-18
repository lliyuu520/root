package com.lliyuu520.root.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
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
    default void initPage() {
        final HttpServletRequest request = IpUtil.getRequest();
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        int i = 1;
        int j = 10;
        if (StrUtil.isNotEmpty(pageNum) && StrUtil.isNotEmpty(pageSize)) {
            i = Integer.parseInt(pageNum);
            j = Integer.parseInt(pageSize);
        }
        PageHelper.startPage(i, j);
    }


}
