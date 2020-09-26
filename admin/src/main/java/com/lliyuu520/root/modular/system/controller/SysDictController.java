package com.lliyuu520.root.modular.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lliyuu520.root.core.log.BusinessLog;
import com.lliyuu520.root.core.log.LogModel;
import com.lliyuu520.root.core.log.LogType;
import com.lliyuu520.root.core.utils.PageFactory;
import com.lliyuu520.root.modular.system.dto.SysDictDTO;
import com.lliyuu520.root.modular.system.query.SysDictQuery;
import com.lliyuu520.root.modular.system.service.SysDictService;
import com.lliyuu520.root.modular.system.vo.SysDictNodeVO;
import com.lliyuu520.root.modular.system.vo.SysDictVO;
import com.lliyuu520.root.response.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author liliangyu
 */
@RestController
@RequestMapping("/sysDict")
@Slf4j
@Api(tags = {"字典"})
@AllArgsConstructor
public class SysDictController {


    private final SysDictService sysDictService;

    /**
     * 字典
     */
    @ApiOperation("/字典列表")
    @BusinessLog(model = LogModel.DICT, type = LogType.LIST)
    @PostMapping(value = "/list")
    public AjaxResult list(@RequestBody SysDictQuery sysDictQuery) {

        IPage<SysDictVO> pageVO = new PageFactory<SysDictVO>().defaultPage();
        pageVO = sysDictService.selectDict(pageVO, sysDictQuery);
        return AjaxResult.success(pageVO);
    }

    /**
     * 新增字典
     */
    @ApiOperation("/字典新增")
    @BusinessLog(model = LogModel.DICT, type = LogType.ADD)
    @PostMapping(value = "/add")
    public AjaxResult add(@RequestBody SysDictDTO sysDictDTO) {

        sysDictService.addSysDict(sysDictDTO);

        return AjaxResult.success();
    }

    /**
     * 编辑字典
     */
    @ApiOperation("/字典编辑")
    @BusinessLog(model = LogModel.DICT, type = LogType.EDIT)
    @PostMapping(value = "/edit")
    public AjaxResult edit(@RequestBody SysDictDTO sysDictDTO) {

        sysDictService.editSysDict(sysDictDTO);

        return AjaxResult.success();
    }

    /**
     * 新增字典
     */
    @ApiOperation("/字典详情")
    @BusinessLog(model = LogModel.DICT, type = LogType.ADD)
    @PostMapping(value = "/detail")
    public AjaxResult detail(String id) {

        SysDictNodeVO byId = sysDictService.selectSysDictNode(id);

        return AjaxResult.success(byId);
    }

}
