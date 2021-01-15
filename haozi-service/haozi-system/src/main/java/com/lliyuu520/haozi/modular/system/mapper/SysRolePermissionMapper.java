package com.lliyuu520.haozi.modular.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lliyuu520.haozi.modular.system.entity.SysRolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liliangyu
 */
@Repository
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {


    /**
     * 删除中间表的角色
     *
     * @param roleId
     */
    void deleteByRoleId(@Param("roleId") String roleId);
}
