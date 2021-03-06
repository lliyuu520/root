package com.lliyuu520.haozi.modular.area.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.modular.area.dto.AreaDTO;
import com.lliyuu520.haozi.modular.area.entity.Area;
import com.lliyuu520.haozi.modular.area.query.AreaQuery;
import com.lliyuu520.haozi.modular.area.vo.AreaVO;

import java.util.List;

/**
 * 部门service 接口
 *
 * @author liliangyu
 * @date 2019/6/18
 */
public interface AreaService extends IService<Area> {
    /**
     * 查询子区域
     *
     * @param parentCode 父code
     * @return 子区域
     */
    List<AreaVO> listByParentCode(Long parentCode);

    /**
     * 查询完整名称
     *
     * @param areaQuery
     * @return
     */
    String getName(AreaQuery areaQuery);

    /**
     * 新增
     *
     * @param areaDTO
     */
    void insertArea(AreaDTO areaDTO);

    /**
     * 编辑
     *
     * @param areaDTO
     */
    void updateArea(AreaDTO areaDTO);

    /**
     * 高级查询
     *
     * @param areaQuery
     * @return
     */
    List<AreaVO> listByQuery(AreaQuery areaQuery);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    AreaVO getDetailById(Long id);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(Long id);
}
