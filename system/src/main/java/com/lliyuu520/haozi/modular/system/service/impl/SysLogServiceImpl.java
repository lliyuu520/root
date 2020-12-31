package com.lliyuu520.haozi.modular.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.haozi.core.log.BusinessLog;
import com.lliyuu520.haozi.modular.system.entity.SysLog;
import com.lliyuu520.haozi.modular.system.mapper.SysLogMapper;
import com.lliyuu520.haozi.modular.system.service.SysLogService;
import com.lliyuu520.haozi.modular.system.service.SysUserService;
import com.lliyuu520.haozi.utils.IpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author zmdTech123
 * @since 2018-02-22
 */
@Service
@RequiredArgsConstructor
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    private final SysUserService userService;
    /**
     * 保存日志
     *
     * @param businessLog
     */
    @Override
    public void insertLog(BusinessLog businessLog) {
        SysLog sysLog = new SysLog();
        String currentUser = userService.getCurrentUser().getName();
        String ip = IpUtil.getIp();
        sysLog.setIp(ip);
        sysLog.setUsername(currentUser);
        String requestURI = IpUtil.getRequest().getRequestURI();
        sysLog.setUrl(requestURI);
        sysLog.setCreateTime(LocalDateTime.now());
        sysLog.setType(businessLog.type().getKey());
        sysLog.setModel(businessLog.model().getKey());
        this.save(sysLog);
    }
}
