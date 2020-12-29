package com.lliyuu520.haozi.modular.system.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lliyuu520.haozi.controller.BaseController;
import com.lliyuu520.haozi.core.log.BusinessLog;
import com.lliyuu520.haozi.core.log.LogModel;
import com.lliyuu520.haozi.core.log.LogType;
import com.lliyuu520.haozi.modular.system.dto.SysDeptDTO;
import com.lliyuu520.haozi.modular.system.entity.SysDept;
import com.lliyuu520.haozi.modular.system.query.SysDictQuery;
import com.lliyuu520.haozi.modular.system.service.SysDeptService;
import com.lliyuu520.haozi.modular.system.vo.HeroVO;
import com.lliyuu520.haozi.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门控制器
 *
 * @author liliangyu
 */
@RestController
@RequestMapping("/hero")
@Slf4j
@RequiredArgsConstructor
public class HeroController implements BaseController {



    /**
     * list
     */
    @PostMapping(value = "/list")
    public List<HeroVO> list() {
        log.info("----------------------------");
        final ArrayList<HeroVO> heroVOS = new ArrayList<>();
        heroVOS.add(new HeroVO(1L,"aaa"));
        heroVOS.add(new HeroVO(2L,"bbb"));
        heroVOS.add(new HeroVO(3L,"ccc"));
        heroVOS.add(new HeroVO(5L,"ddd"));
        heroVOS.add(new HeroVO(5L,"eee"));
        heroVOS.add(new HeroVO(6L,"fff"));
        heroVOS.add(new HeroVO(7L,"ggg"));
        heroVOS.add(new HeroVO(8L,"hhh"));
        heroVOS.add(new HeroVO(9L,"iii"));
        return heroVOS;
    }


}
