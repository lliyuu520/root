package com.lliyuu520.root.core.log;



import com.lliyuu520.root.core.utils.HttpUtil;
import com.lliyuu520.root.modular.system.entity.SysLog;
import com.lliyuu520.root.modular.system.service.SysLogService;
import com.lliyuu520.root.modular.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 * 日志生成器
 *
 * @author liliangyu
 * @date 2019-05-17
 */
@Component
public class LogManage {
    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private SysUserService userService;

    /**
     * 插入日志
     *
     * @param log
     */
    public void insert(BusinessLog log) {

        SysLog sysOperationLog = new SysLog();
        String currentUser = userService.getCurrentUser().getName();
        String ip = HttpUtil.getIp();
        sysOperationLog.setIp(ip);
        sysOperationLog.setUsername(currentUser);
        String requestURI = HttpUtil.getRequest().getRequestURI();
        sysOperationLog.setUrl(requestURI);
        sysOperationLog.setCreateTime(new Date());
        sysOperationLog.setTitle(log.model().getValue());
        sysOperationLog.setType(log.type().getKey());
        sysOperationLog.setName(LogType.valueOf(log.type().getKey()));

        CompletableFuture.runAsync(() -> {
            sysLogService.save(sysOperationLog);
        });
    }

}
