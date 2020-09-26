package com.lliyuu520.root.common.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 控制器基类
 * @author liliangyu
 * @date 2019-08-05
 */
public interface BaseController {
    /**
     * 拷贝部分属性
     * @param source
     * @param target
     */
    default void transPage(IPage source, IPage target) {
        long total = source.getTotal();
        long current = source.getCurrent();
        long pages = source.getPages();
        long size = source.getSize();
        target.setTotal(total);
        target.setCurrent(current);
        target.setPages(pages);
        target.setSize(size);
    }

}
