package com.lliyuu520.root.core.config;

import lombok.Data;
import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;

/**
 * @author liliangyu
 * @date 2019/8/12
 */
@Data
public class UrlRole {
    private String url;
    private Collection<ConfigAttribute> roleName;
}
