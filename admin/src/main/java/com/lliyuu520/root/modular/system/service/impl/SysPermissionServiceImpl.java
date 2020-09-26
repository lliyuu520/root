package com.lliyuu520.root.modular.system.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lliyuu520.root.core.config.UrlRole;
import com.lliyuu520.root.core.utils.MenuParser;
import com.lliyuu520.root.modular.system.entity.SysPermission;
import com.lliyuu520.root.modular.system.mapper.SysPermissionMapper;
import com.lliyuu520.root.modular.system.service.SysPermissionService;
import com.lliyuu520.root.modular.system.service.SysUserService;
import com.lliyuu520.root.modular.system.vo.MenuNode;
import com.lliyuu520.root.modular.system.vo.SysPermissionVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 资源service 实现
 *
 * @author liliangyu
 * @date 2019/6/18
 */
@Service
@Slf4j
@AllArgsConstructor
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {


    private final SysUserService sysUserService;

    @Override
    public List<UrlRole> getRolePermission() {
        List<String> url = this.baseMapper.getUrl();

        return url.stream().map(this::apply).collect(Collectors.toList());

    }

    /**
     * 获取资源角色
     *
     * @return
     */
    @Override
    public List<SysPermissionVO> getPermissionRole() {
        List<UrlRole> list = this.getRolePermission();
        ArrayList<SysPermissionVO> vos = new ArrayList<>();
        list.forEach(m -> {
            SysPermissionVO sysPermissionVO = new SysPermissionVO();
            sysPermissionVO.setUrl(m.getUrl());
            vos.add(sysPermissionVO);
        });

        vos.forEach(n -> {
            String url = n.getUrl();
            List<String> strings = this.baseMapper.selectRoleByUrl(url);
            n.setRoles(strings);

        });
        return vos;

    }

    /**
     * 获取权限树
     *
     * @return
     */
    @Override
    public List<Tree<String>> getMenuNodeByRoleId(Long roleId) {
        List<MenuNode> rootMenu = this.baseMapper.selectByRoleId(roleId);
        List<Tree<String>> build = getTrees(rootMenu);
//转换器

        return build;
    }

    /**
     * getTrees
     * @param rootMenu
     * @return
     */
    private List<Tree<String>> getTrees(List<MenuNode> rootMenu) {
        List<TreeNode<String>> nodeList = rootMenu.stream().map(menuNode->{
            TreeNode<String> longTreeNode = new TreeNode<>(menuNode.getId().toString(), menuNode.getParentId().toString(), menuNode.getName(), menuNode.getSort());
            HashMap<String, Object> map = new HashMap<>(4);
            map.put("checked",menuNode.getChecked());
            map.put("url",menuNode.getUrl());
            map.put("icon",menuNode.getIcon());
            longTreeNode.setExtra(map);
            return longTreeNode;
        }).collect(Collectors.toList());

        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
// 自定义属性名 都要默认值的
        treeNodeConfig.setWeightKey("sort");
// 最大递归深度
        MenuParser<String> stringMenuParser = new MenuParser<>();
        return TreeUtil.build(nodeList, "0", treeNodeConfig, stringMenuParser);
    }

    /**
     * 获取用户菜单
     *
     * @return
     */
    @Override
    public List<Tree<String>> getMenuNodeByUserId() {
        Long userId = sysUserService.getCurrentUser().getId();
        List<MenuNode> rootMenu = this.baseMapper.selectByUserId(userId);
        List<Tree<String>> trees = getTrees(rootMenu);
        return trees;
    }



    private UrlRole apply(String m) {
        UrlRole urlRole = new UrlRole();
        urlRole.setUrl(m);
        List<String> strings = this.baseMapper.selectRoleByUrl(m);
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        configAttributes = strings.stream().map(n -> (ConfigAttribute) new SecurityConfig(n)).collect(Collectors.toList());
        urlRole.setRoleName(configAttributes);
        return urlRole;
    }
}
