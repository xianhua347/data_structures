package com.tree.BinaryTree;

import com.tree.AbstractTree;

public class BTree<T> extends AbstractTree<T> {

    public BTree(T key){
        root = new BinaryTreeNode<>();
    }

    /**
     * 孩子节点个数
     *
     * @return int
     */
    @Override
    public int childCount() {
        return 0;
    }

    /**
     * @param p 节点
     * @param i 节点位置
     * @return BinaryTreeNode<T>
     */
    @Override
    public BinaryTreeNode<T> getChild(BinaryTreeNode<T> p, int i) {
        return null;
    }

    @Override
    public BinaryTreeNode<T> getLastChild(BinaryTreeNode<T> p) {
        return null;
    }

    @Override
    public BinaryTreeNode<T> getLastSibling(BinaryTreeNode<T> p) {
        return null;
    }

    @Override
    public BinaryTreeNode<T> getParent(BinaryTreeNode<T> node) {
        return null;
    }

    private BinaryTreeNode<T> searchRecursive(BinaryTreeNode<T> p, T key){
        if (p == null || p.data.equals(key))
            return p;
        BinaryTreeNode<T> pleft = searchRecursive(p.leftChild,key);
        return pleft != null ? pleft : searchRecursive(p.rightChild,key);
    }

    @Override
    public BinaryTreeNode<T> search(T key) {
        return searchRecursive(root, key);
    }

    /**
     * @param x NULL
     */
    @Override
    public void insertRoot(T x) {

    }

    /**
     * @param p 节点
     * @param x 数据
     * @param i 位置
     * @return BinaryTreeNode<T>
     */
    @Override
    public BinaryTreeNode<T> insertChild(BinaryTreeNode<T> p, T x, int i) {
        return null;
    }

    @Override
    public BinaryTreeNode<T> insertLastSibling(BinaryTreeNode<T> p, T x, int i) {
        return null;
    }

    /**
     * @param p 节点
     * @param i 位置
     */
    @Override
    public void removeChild(BinaryTreeNode<T> p, int i) {

    }

    /**
     * 删除整个树
     */
    @Override
    public void removeAll() {

    }

    public BinaryTreeNode<T> insert(BinaryTreeNode<T> p, T key){
        if (p == null){
            p = new BinaryTreeNode<>();
            return p;
        }
        if (p.leftChild == null){
            p.leftChild = new BinaryTreeNode<T>(key);
            return p.leftChild;
        }
        if (p.rightChild == null){
            p.rightChild = new BinaryTreeNode<T>(key);
            return p.rightChild;
        }
        return  null;
    }

    public static void main(String[] args) {
        final BTree<Character> tree = new BTree<>('a');
        final BinaryTreeNode<Character> leftChild = tree.insert(tree.root, 'B');
        final BinaryTreeNode<Character> rightChild = tree.insert(tree.root, 'c');
        tree.insert(leftChild,'d');
        tree.insert(rightChild,'E');
        tree.inOrder();
    }

}
