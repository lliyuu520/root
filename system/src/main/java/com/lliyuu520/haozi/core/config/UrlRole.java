package com.lliyuu520.haozi.core.config;

import lombok.Data;
import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.List;

/**
 * 权限集合
 * @author liliangyu
 * @date 2019/8/12
 */
@Data
public class UrlRole {
    /**
     * 访问地址
     */
    private String url;
    /**
     * 需要的角色
     */
    private Collection<ConfigAttribute> roleName;
}
