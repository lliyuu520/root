package com.lliyuu520.root.modular.log.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.lliyuu520.root.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * account
 *
 * @author lliyuu520
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Log {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 操作模块
     */
    private String title;
    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    private Integer type;
    /**
     * 业务类型
     */
    private String name;
    /**
     * 操作人员
     */
    private String username;
    /**
     * 请求url
     */
    private String url;
    /**
     * 操作地址
     */
    private String ip;
    /**
     * 请求参数
     */
    private String param;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
