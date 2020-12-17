package com.lliyuu520.root.modular.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lliyuu520.root.modular.system.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liliangyu
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 根据用户ID查询用户角色
     * @param userId
     * @return
     */
    List<SysRole> getSysRolesByUserId(@Param("userId") Long userId);


}
