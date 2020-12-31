package com.lliyuu520.haozi.modular.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.modular.dto.HeroDTO;
import com.lliyuu520.haozi.modular.entity.Hero;
import com.lliyuu520.haozi.modular.query.HeroQuery;
import com.lliyuu520.haozi.modular.vo.HeroVO;

import java.util.List;

/**
 * (Hero)表服务接口
 *
 * @author lliyuu520
 * @since 2020-12-31 14:12:28
 */
public interface HeroService extends IService<Hero> {

    /**
     * 新增
     *
     * @param heroDTO}
     */
    void insertHero(HeroDTO heroDTO);

    /**
     * 编辑
     *
     * @param heroDTO
     */
    void updateHero(HeroDTO heroDTO);

    /**
     * 高级查询
     *
     * @param heroQuery
     * @return
     */
    List<HeroVO> listByQuery(HeroQuery heroQuery);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    HeroVO getDetailById(Long id);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(Long id);

}
