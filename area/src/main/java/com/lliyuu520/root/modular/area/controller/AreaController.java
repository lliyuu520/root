package com.lliyuu520.root.modular.area.controller;

import com.lliyuu520.root.controller.BaseController;
import com.lliyuu520.root.modular.area.query.AreaQuery;
import com.lliyuu520.root.modular.area.service.AreaService;
import com.lliyuu520.root.modular.area.vo.AreaVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门控制器
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
     * listByParentCode
     */
    @PostMapping(value = "/listByParentCode")
    public List<AreaVO> listByParentCode(@RequestBody AreaQuery areaQuery) {
        final Long parentCode = areaQuery.getParentCode();
        return areaService.listByParentCode(parentCode);
    }

    /**
     * listByParentCode
     */
    @PostMapping(value = "/getName")
    public String getName(@RequestBody AreaQuery areaQuery) {
        return areaService.getName(areaQuery);
    }




}
