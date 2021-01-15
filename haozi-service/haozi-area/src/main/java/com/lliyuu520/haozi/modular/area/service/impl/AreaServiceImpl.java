package com.lliyuu520.haozi.modular.area.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.CharUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.haozi.modular.area.dto.AreaDTO;
import com.lliyuu520.haozi.modular.area.entity.Area;
import com.lliyuu520.haozi.modular.area.mapper.AreaMapper;
import com.lliyuu520.haozi.modular.area.query.AreaQuery;
import com.lliyuu520.haozi.modular.area.service.AreaService;
import com.lliyuu520.haozi.modular.area.vo.AreaVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门service 实现
 *
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    /**
     * 查询子区域
     *
     * @param parentCode 父code
     * @return 子区域
     */
    @Override
    public List<AreaVO> listByParentCode(Long parentCode) {
        final LambdaQueryWrapper<Area> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Area::getParentCode, parentCode);
        return this.list(wrapper).stream().map(AreaVO::toVO).collect(Collectors.toList());

    }

    /**
     * 查询完整名称
     *
     * @param areaQuery
     * @return
     */
    @Override
    public String getName(AreaQuery areaQuery) {
        //此处采用递归查询会不会好点
        final Long code = areaQuery.getCode();
        final LambdaQueryWrapper<Area> wrapper = Wrappers.lambdaQuery();

        final Area area = this.getById(code);
        Long parentCode = area.getParentCode();
        List<String> names = new ArrayList<>();
        names.add(area.getName());
        while (parentCode != 0L) {
            final Area temp = this.getById(parentCode);
            names.add(temp.getName());
            parentCode = temp.getParentCode();
        }
        log.info("names:{}", names);
        final List<String> reverse = CollUtil.reverse(names);
        return String.join(String.valueOf(CharUtil.DASHED), reverse);
    }

    /**
     * 新增
     *
     * @param areaDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertArea(AreaDTO areaDTO) {
        final Area area = BeanUtil.copyProperties(areaDTO, Area.class);
        this.save(area);
    }

    /**
     * 编辑
     *
     * @param areaDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateArea(AreaDTO areaDTO) {
        final Area area = BeanUtil.copyProperties(areaDTO, Area.class);
        this.updateById(area);
    }

    /**
     * 高级查询
     *
     * @param areaQuery
     * @return
     */
    @Override
    public List<AreaVO> listByQuery(AreaQuery areaQuery) {
        final LambdaQueryWrapper<Area> wrapper = Wrappers.lambdaQuery();
        //todo
        final List<AreaVO> collect = this.list(wrapper).stream().map(m -> {
            final AreaVO areaVO = BeanUtil.copyProperties(m, AreaVO.class);
            return areaVO;
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
    public AreaVO getDetailById(Long id) {
        final Area area = this.getById(id);
        final AreaVO areaVO = BeanUtil.copyProperties(area, AreaVO.class);
        return areaVO;
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
