package com.tree.BinaryTree;

public interface BinaryTreeInter<T> {
     boolean isEmpty();
     int count();
     int height();
     void preOrder(BinaryTreeNode<T> node);
     void inOrder(BinaryTreeNode<T> node);
     void postOrder(BinaryTreeNode<T> node);
     BinaryTreeNode<T> search(T key);
     BinaryTreeNode<T> getParent(BinaryTreeNode<T> node);
     void insertRoot(T x);
     BinaryTreeNode<T> insertChild(BinaryTreeNode<T> p, T x, boolean leftChild);
     void removeChild(BinaryTreeNode<T> p, boolean leftChild);
     void removeALl();

}
