package com.lliyuu520.haozi.core.utils;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.parser.NodeParser;
import cn.hutool.core.map.MapUtil;

import java.util.Map;

/**
 * @author lliyuu520
 * @date 2020/9/2622:54
 */
public class MenuParser<T> implements NodeParser<TreeNode<T>, T> {

    /**
     * @param tree   源数据实体
     * @param treeNode treeNode
     */
    @Override
    public void parse(TreeNode<T> treeNode, Tree<T> tree) {
        tree.setId(treeNode.getId());
        tree.setParentId(treeNode.getParentId());
        tree.setWeight(treeNode.getWeight());
        tree.setName(treeNode.getName());

        //扩展字段
        final Map<String, Object> extra = treeNode.getExtra();
        if(MapUtil.isNotEmpty(extra)){
            extra.forEach(tree::putExtra);
        }
    }
}
