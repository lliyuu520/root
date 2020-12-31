package com.lliyuu520.haozi.modular.area.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.modular.area.dto.AreaDTO;
import com.lliyuu520.haozi.modular.area.query.AreaQuery;
import com.lliyuu520.haozi.modular.area.service.AreaService;
import com.lliyuu520.haozi.modular.area.vo.AreaVO;
import com.lliyuu520.haozi.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

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
     *
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

    /**
     * 新增
     *
     * @param areaDTO
     * @return
     */
    @PostMapping
    public AjaxResult<Void> insert(@RequestBody AreaDTO areaDTO) {
        this.areaService.insertArea(areaDTO);
        return success();
    }

    /**
     * 修改
     *
     * @param areaDTO
     * @return
     */
    @PutMapping
    public AjaxResult<Void> update(@RequestBody AreaDTO areaDTO) {
        this.areaService.insertArea(areaDTO);
        return success();
    }

    /**
     * 带分页高级查询
     *
     * @param areaQuery
     * @return
     */
    @PostMapping("/list")
    public AjaxResult<PageInfo<AreaVO>> list(@RequestBody AreaQuery areaQuery) {
        PageHelper.startPage(pageNum(), pageSize());
        final List<AreaVO> areaVOS = this.areaService.listByQuery(areaQuery);
        return success(PageInfo.of(areaVOS));

    }

    /**
     * 根据ID查询详情
     *
     * @param id id
     * @return
     */
    @GetMapping("/{id}")
    public AjaxResult<AreaVO> list(@PathVariable Long id) {
        final AreaVO areaVO = this.areaService.getDetailById(id);
        return success(areaVO);
    }

    /**
     * 根据ID逻辑删除
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/{id}")
    public AjaxResult<Void> delete(@PathVariable Long id) {
        this.areaService.deleteById(id);
        return success();
    }

}
