package com.lliyuu520.root.modular.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.modular.system.dto.SysDeptDTO;
import com.lliyuu520.root.modular.system.entity.SysDept;
import com.lliyuu520.root.modular.system.mapper.SysDeptMapper;
import com.lliyuu520.root.modular.system.service.SysDeptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门service 实现
 *
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@AllArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {
    /**
     * 添加部门
     *
     * @param sysDeptDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveDept(SysDeptDTO sysDeptDTO) {
        SysDept sysDept = new SysDept();
        BeanUtil.copyProperties(sysDeptDTO, sysDept);
        this.save(sysDept);
    }

    /**
     * 修改部门
     *
     * @param sysDeptDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editDept(SysDeptDTO sysDeptDTO) {
        String id = sysDeptDTO.getId();
        SysDept sysDept = this.getById(id);
        BeanUtil.copyProperties(sysDeptDTO, sysDept, CopyOptions.create().ignoreNullValue());
        this.updateById(sysDept);
    }
}
