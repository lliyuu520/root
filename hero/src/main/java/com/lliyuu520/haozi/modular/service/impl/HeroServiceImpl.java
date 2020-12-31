package com.lliyuu520.haozi.modular.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.haozi.modular.dto.HeroDTO;
import com.lliyuu520.haozi.modular.entity.Hero;
import com.lliyuu520.haozi.modular.mapper.HeroMapper;
import com.lliyuu520.haozi.modular.query.HeroQuery;
import com.lliyuu520.haozi.modular.service.HeroService;
import com.lliyuu520.haozi.modular.vo.HeroVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (Hero)表服务实现类
 *
 * @author lliyuu520
 * @since 2020-12-31 14:12:21
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements HeroService {


    /**
     * 新增
     *
     * @param heroDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertHero(HeroDTO heroDTO) {
        final Hero hero = BeanUtil.copyProperties(heroDTO, Hero.class);
        this.save(hero);
    }

    /**
     * 编辑
     *
     * @param heroDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHero(HeroDTO heroDTO) {
        final Hero hero = BeanUtil.copyProperties(heroDTO, Hero.class);
        this.updateById(hero);
    }

    /**
     * hero查询
     *
     * @param heroQuery
     * @return
     */
    @Override
    public List<HeroVO> listByQuery(HeroQuery heroQuery) {
        final LambdaQueryWrapper<Hero> wrapper = Wrappers.lambdaQuery();
        //todo
        final List<HeroVO> collect = this.list(wrapper).stream().map(m -> {
            final HeroVO heroVO = BeanUtil.copyProperties(m, HeroVO.class);
            return heroVO;
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public HeroVO getDetailById(Long id) {
        final Hero hero = this.getById(id);
        final HeroVO heroVO = BeanUtil.copyProperties(hero, HeroVO.class);
        return heroVO;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        this.removeById(id);
    }
}
