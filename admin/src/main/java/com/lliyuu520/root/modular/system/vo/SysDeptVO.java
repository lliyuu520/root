package com.lliyuu520.root.modular.system.vo;

import lombok.Data;

/**
 * @author liliangyu
 * @date 2019/7/29
 */
@Data
public class SysDeptVO {

    /**
     * id
     */
    private String id;
    /**
     * 中文名称
     */
    private String name;

    /**
     * 英语名称
     */
    private String eName;
    /**
     * 备注
     */
    private String remark;
}
