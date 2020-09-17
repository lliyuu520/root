package com.lliyuu520.root.core.utils;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zmdtech.xlyy.common.utils.HttpUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * BootStrap Table默认的分页参数创建
 *
 * @author zmdTech
 * @date 2017-04-05 22:25
 */

public class PageFactory<T> {

    public Page<T> initPage() {
        return new Page<>(1, 10);
    }

    public IPage<T> defaultPage() {
        HttpServletRequest request = HttpUtil.getRequest();
        /**
         * 当前第几页
         */
        String pageIndex = request.getParameter("pageIndex");
        if (StrUtil.isBlank(pageIndex)) {
            pageIndex = "1";
        }
        /**
         * 每页条数
         */
        String pageSize = request.getParameter("pageSize");
        if (StrUtil.isBlank(pageSize)) {
            pageSize = "10";
        }


        //每页的偏移量(本页当前有多少条)

        return new Page<>(Integer.parseInt(pageIndex), Integer.parseInt(pageSize));

    }

}
