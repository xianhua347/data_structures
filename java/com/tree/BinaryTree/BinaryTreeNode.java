package com.tree.BinaryTree;

public class BinaryTreeNode<T>{
    public T data;
    public BinaryTreeNode<T> leftChild,rightChild;

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryTreeNode(T data){
        this(data, null, null);
    }

    public BinaryTreeNode(){
        this(null, null, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
