package com.lliyuu520.haozi.modular.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.modular.dto.HeroDTO;
import com.lliyuu520.haozi.modular.query.HeroQuery;
import com.lliyuu520.haozi.modular.service.HeroService;
import com.lliyuu520.haozi.modular.vo.HeroVO;
import com.lliyuu520.haozi.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Hero)表控制层
 *
 * @author lliyuu520
 * @since 2020-12-31 14:12:21
 */
@Slf4j
@RestController
@RequestMapping("hero")
@RequiredArgsConstructor
public class HeroController implements BaseController {

    private final HeroService heroService;

    /**
     * 新增
     *
     * @param heroDTO
     * @return
     */
    @PostMapping
    public AjaxResult<Void> insert(@RequestBody HeroDTO heroDTO) {
        this.heroService.insertHero(heroDTO);
        return success();
    }

    /**
     * 修改
     *
     * @param heroDTO
     * @return
     */
    @PutMapping
    public AjaxResult<Void> update(@RequestBody HeroDTO heroDTO) {
        this.heroService.updateHero(heroDTO);
        return success();
    }

    /**
     * 带分页高级查询
     *
     * @param heroQuery
     * @return
     */
    @PostMapping("/list")
    public AjaxResult<PageInfo<HeroVO>> list(@RequestBody HeroQuery heroQuery) {
        PageHelper.startPage(pageNum(), pageSize());
        final List<HeroVO> heroVOS = this.heroService.listByQuery(heroQuery);
        return success(PageInfo.of(heroVOS));
    }

    /**
     * 根据ID查询详情
     *
     * @param id id
     * @return
     */
    @GetMapping("/{id}")
    public AjaxResult<HeroVO> list(@PathVariable Long id) {
        final HeroVO heroVO = this.heroService.getDetailById(id);
        return success(heroVO);
    }

    /**
     * 根据ID逻辑删除
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/{id}")
    public AjaxResult<Void> delete(@PathVariable Long id) {
        this.heroService.deleteById(id);
        return success();
    }
}
