package com.lliyuu520.root.core.log;


import com.lliyuu520.root.modular.system.entity.SysLog;
import com.lliyuu520.root.modular.system.service.SysLogService;
import com.lliyuu520.root.modular.system.service.SysUserService;
import com.lliyuu520.root.utils.IpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

/**
 * 日志生成器
 *
 * @author liliangyu
 * @date 2019-05-17
 */
@Component
@RequiredArgsConstructor
public class LogManage {
    private final SysLogService sysLogService;
    private final SysUserService userService;

    /**
     * 插入日志
     *
     * @param log
     */
    public void insert(BusinessLog log) {

        SysLog sysOperationLog = new SysLog();
        String currentUser = userService.getCurrentUser().getName();
        String ip = IpUtil.getIp();
        sysOperationLog.setIp(ip);
        sysOperationLog.setUsername(currentUser);
        String requestURI = IpUtil.getRequest().getRequestURI();

        sysOperationLog.setUrl(requestURI);
        sysOperationLog.setCreateTime(LocalDateTime.now());
        sysOperationLog.setTitle(log.model().getValue());
        sysOperationLog.setType(log.type().getKey());
        sysOperationLog.setName(LogType.valueOf(log.type().getKey()));

        CompletableFuture.runAsync(() -> {
            sysLogService.save(sysOperationLog);
        });
    }

}
