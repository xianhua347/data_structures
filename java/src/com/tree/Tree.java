package com.tree;

import com.tree.BinaryTree.BinaryTreeNode;

/**
 * 树的抽象接口
 * @param <T>
 */
public interface Tree<T> {
    /**
     * 是否为空
     * @return boolean
     */
    boolean isEmpty();  //是否为空

    /**
     * 节点个数
     * @return int
     */
    int count(); //节点个数

    /**
     * 树的高度
     * @return int
     */
    int height(); //树的高度

    /**
     * 孩子节点个数
     * @return int
     */
    int childCount(); //孩子节点个数

    /**
     * 先序遍历
     */
    void preOrder(); //先序遍历

    /**
     * 后序遍历
     */
    void postOrder(); //后序遍历

    /**
     * 层次遍历
     */
    void levelOrder(); //层次遍历

    /**
     * @param p 节点
     * @param i 节点位置
     * @return  com.tree.BinaryTree.BinaryTreeNode<T>
     */
    BinaryTreeNode<T> getChild(BinaryTreeNode<T> p, int i); //第i个节点子节点
    BinaryTreeNode<T> getLastChild(BinaryTreeNode<T> p); //返回P节点的最后一个节点
    BinaryTreeNode<T> getLastSibling(BinaryTreeNode<T> p); //返回p的最后一个兄弟节点
    BinaryTreeNode<T> getParent(BinaryTreeNode<T> node); //获得父节点

    /**
     * @param x data
     * @return BinaryTreeNode<t>
     */
    BinaryTreeNode<T> search(T x); //搜索x节点

    /**
     * @param x NULL
     */
    void insertRoot(T x); //插入x为根节点

    /**
     * @param p 节点
     * @param x 数据
     * @param i 位置
     * @return BinaryTreeNode<T>
     */
    BinaryTreeNode<T> insertChild(BinaryTreeNode<T> p, T x,int i); //插入最后一个节点
    BinaryTreeNode<T> insertLastSibling(BinaryTreeNode<T> p, T x, int i);//插入最后一个兄弟节点

    /**
     * @param p 节点
     * @param i 位置
     */
    void removeChild(BinaryTreeNode<T> p, int i); //删除子节点
    /**
     * 删除整个树
     */
    void removeAll(); //删除树
}
