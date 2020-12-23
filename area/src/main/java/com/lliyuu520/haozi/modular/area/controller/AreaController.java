package com.lliyuu520.haozi.modular.area.controller;

import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.modular.area.query.AreaQuery;
import com.lliyuu520.haozi.modular.area.service.AreaService;
import com.lliyuu520.haozi.modular.area.vo.AreaVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 行政区划
 *
 * @author liliangyu
 */
@RestController
@RequestMapping("/area")
@Slf4j
@RequiredArgsConstructor
public class AreaController implements BaseController {


    private final AreaService areaService;

    /**
     * 根据父编码查询子区域集合
     * @param areaQuery
     * @return
     */
    @PostMapping(value = "/listByParentCode")
    @Cacheable("listByParentCode")
    public List<AreaVO> listByParentCode(@RequestBody AreaQuery areaQuery) {
        final Long parentCode = areaQuery.getParentCode();
        return areaService.listByParentCode(parentCode);
    }

    /**
     * 根据code查询全名称
     */
    @PostMapping(value = "/getName")
    @Cacheable("getName")
    public String getName(@RequestBody AreaQuery areaQuery) {
        return areaService.getName(areaQuery);
    }




}
