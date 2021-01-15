package com.lliyuu520.haozi.modular.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.core.log.BusinessLog;
import com.lliyuu520.haozi.core.log.LogModel;
import com.lliyuu520.haozi.core.log.LogType;
import com.lliyuu520.haozi.modular.system.dto.SysDictDTO;
import com.lliyuu520.haozi.modular.system.query.SysDictQuery;
import com.lliyuu520.haozi.modular.system.service.SysDictService;
import com.lliyuu520.haozi.modular.system.vo.SysDictNodeVO;
import com.lliyuu520.haozi.modular.system.vo.SysDictVO;
import com.lliyuu520.haozi.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典控制器
 *
 * @author liliangyu
 */
@RestController
@RequestMapping("/sysDict")
@Slf4j
@RequiredArgsConstructor
public class SysDictController implements BaseController {


    private final SysDictService sysDictService;

    /**
     * 字典
     */
    @BusinessLog(model = LogModel.DICT, type = LogType.LIST)
    @PostMapping("/list")
    public AjaxResult<PageInfo<SysDictVO>> list(@RequestBody SysDictQuery sysDictQuery) {
        PageHelper.startPage(pageNum(), pageSize());
        final List<SysDictVO> sysDictVOS = this.sysDictService.selectDict(sysDictQuery);
        final PageInfo<SysDictVO> pageInfo = PageInfo.of(sysDictVOS);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 新增字典
     */
    @BusinessLog(model = LogModel.DICT, type = LogType.INSERT)
    @PostMapping("/add")
    public AjaxResult<Void> add(@RequestBody SysDictDTO sysDictDTO) {
        sysDictService.addSysDict(sysDictDTO);
        return AjaxResult.success();
    }

    /**
     * 编辑字典
     */
    @BusinessLog(model = LogModel.DICT, type = LogType.EDIT)
    @PutMapping(value = "/edit")
    public AjaxResult<Void> edit(@RequestBody SysDictDTO sysDictDTO) {

        sysDictService.editSysDict(sysDictDTO);

        return AjaxResult.success();
    }

    /**
     * 查看字典详情
     *
     * @param id id
     * @return AjaxResult
     */
    @BusinessLog(model = LogModel.DICT, type = LogType.DETAIL)
    @GetMapping(value = "/{id}")
    public AjaxResult<SysDictNodeVO> detail(@PathVariable Long id) {

        SysDictNodeVO byId = sysDictService.selectSysDictNode(id);

        return AjaxResult.success(byId);
    }

}
