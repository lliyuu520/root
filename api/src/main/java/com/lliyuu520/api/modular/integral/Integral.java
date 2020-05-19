package com.lliyuu520.api.modular.integral;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 资源
 *
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Integral extends Model<Integral> {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * url
     */
    private String name;
    /**
     * 名称
     */
    private Integer score;


}
