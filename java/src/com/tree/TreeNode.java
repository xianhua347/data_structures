package com.tree;

public class TreeNode<T> {
    public T data; //数据
    public TreeNode<T> child; //孩子节点
    public TreeNode<T> sibling; //兄弟节点

    public TreeNode(T data) {
        this.data = data;
        this.child = null;
        this.sibling = null;
    }

    public TreeNode(T data, TreeNode<T> child, TreeNode<T> sibling) {
        this.data = data;
        this.child = child;
        this.sibling = sibling;
    }
}
