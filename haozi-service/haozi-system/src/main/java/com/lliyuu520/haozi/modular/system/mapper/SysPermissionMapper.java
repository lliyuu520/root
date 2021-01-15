package com.lliyuu520.haozi.modular.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.lliyuu520.haozi.modular.system.entity.SysPermission;
import com.lliyuu520.haozi.modular.system.vo.MenuNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源dao
 * @author liliangyu
 */
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {


    /**
     * 查询url
     *
     * @return
     */

    List<String> getUrl();

    /**
     * 查询角色
     * @param url
     * @return
     */
    List<String> getRoleNameByUrl(@Param("url") String url);


    /**
     * 根据角色ID查询权限树
     * @param roleId 角色ID
     * @return
     */
    List<MenuNode> selectByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据用户ID查询 菜单
     *
     * @param userId
     * @return
     */
    List<MenuNode> selectByUserId(@Param("userId") Long userId);

    /**
     * 根据URL查询角色集合
     *
     * @param url
     * @return
     */
    List<String> selectRoleByUrl(@Param("url") String url);
}
