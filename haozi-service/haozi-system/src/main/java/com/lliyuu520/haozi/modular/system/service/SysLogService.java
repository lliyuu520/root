package com.lliyuu520.haozi.modular.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.core.log.BusinessLog;
import com.lliyuu520.haozi.modular.system.entity.SysLog;

/**
 * <p>
 * 操作日志 服务类
 * </p>
 *
 * @author zmdTech123
 * @since 2018-02-22
 */
public interface SysLogService extends IService<SysLog> {
    /**
     * 保存日志
     * @param businessLog
     */
    void insertLog(BusinessLog businessLog);
}
