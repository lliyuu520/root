package com.lliyuu520.haozi.modular.area.vo;

import cn.hutool.core.bean.BeanUtil;
import com.lliyuu520.haozi.modular.area.entity.Area;
import lombok.Data;

/**
 * @author liliangyu
 * @date 2019/7/29
 */
@Data
public class AreaVO {
    /**
     * 名称
     */
    private String name;
    /**
     * code
     */
    private Long code;
    /**
     * parentCode
     */
    private Long parentCode;
    /**
     * 等级
     */
    private Integer level;


    /**
     * toVO
     * @param area
     * @return
     */
    public static AreaVO toVO(Area area){
        return BeanUtil.copyProperties(area, AreaVO.class);
    }


}
