package com.lliyuu520.haozi.modular.system.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 操作日志记录表 sys_operation_log
 *
 * @author liliangyu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLog implements Serializable {
    /**
     * id
     */
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
