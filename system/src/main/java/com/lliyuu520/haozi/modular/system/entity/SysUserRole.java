package com.lliyuu520.haozi.modular.system.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 资源
 *
 * @author liliangyu
 */
@Data
public class SysUserRole{

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 角色id
     */
    private Long uerId;
    /**
     * 资源id
     */
    private Long roleId;


}
