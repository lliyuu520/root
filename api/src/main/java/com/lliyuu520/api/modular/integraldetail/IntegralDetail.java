package com.lliyuu520.api.modular.integraldetail;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IntegralDetail extends Model<IntegralDetail> {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * score
     */
    private Integer score;
    /**
     * 积分总表id
     */
    private Long integralId;


}
