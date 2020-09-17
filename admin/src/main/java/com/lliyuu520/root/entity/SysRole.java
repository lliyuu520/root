package com.lliyuu520.root.entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

/**
 * 角色
 * @author liliangyu
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
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
