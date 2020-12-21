package com.lliyuu520.haozi.modular.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lliyuu520.haozi.modular.system.dto.SysDeptDTO;
import com.lliyuu520.haozi.modular.system.entity.SysDept;

/**
 * 部门service 接口
 *
 * @author liliangyu
 * @date 2019/6/18
 */
public interface SysDeptService extends IService<SysDept> {

    /**
     * 添加部门
     *
     * @param sysDeptDTO
     */
    void saveDept(SysDeptDTO sysDeptDTO);

    /**
     * 修改部门
     *
     * @param sysDeptDTO
     */
    void editDept(SysDeptDTO sysDeptDTO);
}
