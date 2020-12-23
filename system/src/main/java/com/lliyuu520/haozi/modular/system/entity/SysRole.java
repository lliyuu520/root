package com.lliyuu520.haozi.modular.system.entity;


import com.lliyuu520.haozi.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

/**
 * 角色
 *
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity implements GrantedAuthority {

    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;


    @Override
    public String getAuthority() {
        return name;
    }

}
