package com.lliyuu520.root.modular.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.root.controller.BaseController;
import com.lliyuu520.root.core.log.BusinessLog;
import com.lliyuu520.root.core.log.LogModel;
import com.lliyuu520.root.core.log.LogType;
import com.lliyuu520.root.modular.system.dto.SysDictDTO;
import com.lliyuu520.root.modular.system.query.SysDictQuery;
import com.lliyuu520.root.modular.system.service.SysDictService;
import com.lliyuu520.root.modular.system.vo.SysDictNodeVO;
import com.lliyuu520.root.modular.system.vo.SysDictVO;
import com.lliyuu520.root.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器
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
    @PostMapping(value = "/list")
    public PageInfo<SysDictVO> list(@RequestBody SysDictQuery sysDictQuery) {
        PageHelper.startPage(pageNum(), pageSize());
        final List<SysDictVO> sysDictVOS = this.sysDictService.selectDict(sysDictQuery);
        final PageInfo<SysDictVO> pageInfo = PageInfo.of(sysDictVOS);
        return pageInfo;
    }

    /**
     * 新增字典
     */
    @BusinessLog(model = LogModel.DICT, type = LogType.ADD)
    @PostMapping(value = "/add")
    public void add(@RequestBody SysDictDTO sysDictDTO) {
        sysDictService.addSysDict(sysDictDTO);
    }

    /**
     * 编辑字典
     */
    @BusinessLog(model = LogModel.DICT, type = LogType.EDIT)
    @PostMapping(value = "/edit")
    public AjaxResult edit(@RequestBody SysDictDTO sysDictDTO) {

        sysDictService.editSysDict(sysDictDTO);

        return AjaxResult.success();
    }

    /**
     * 新增字典
     */
    @BusinessLog(model = LogModel.DICT, type = LogType.ADD)
    @PostMapping(value = "/detail")
    public AjaxResult detail(String id) {

        SysDictNodeVO byId = sysDictService.selectSysDictNode(id);

        return AjaxResult.success(byId);
    }

}
