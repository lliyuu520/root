package com.lliyuu520.haozi.core.config;


import com.lliyuu520.haozi.cache.CacheUtil;
import com.lliyuu520.haozi.modular.system.service.SysPermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

/**
 * 权限
 *
 * @author liliangyu
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {


    private final SysPermissionService sysPermissionService;

    private final CacheUtil<UrlRole> urlRoleCacheUtil;



    /**
     * 返回请求的资源需要的角色
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //object 中包含用户请求的request 信息
        final List<UrlRole> list = urlRoleCacheUtil.rangeAll("url:permission", UrlRole.class);
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        for (UrlRole m : list) {
            String url = m.getUrl();
            final AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(url);
            if (antPathRequestMatcher.matches(request)) {
                return m.getRoleName();
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        //初始化 所有资源 对应的角色
        log.info("--------------------------------------加载权限资源-------------------------------------");
        loadResourceDefine();
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化 所有资源 对应的角色
     */
    private void loadResourceDefine() {
        //权限资源 和 角色对应的表  也就是 角色权限 中间表
        List<UrlRole> rolePermissions = sysPermissionService.getRolePermission();
        urlRoleCacheUtil.pushAll("url:permission", rolePermissions);
    }


}
