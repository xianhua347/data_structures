package com.tree;

import com.stack_queue.queue.LinkedQueue;
import com.tree.BinaryTree.BinaryTreeNode;

public abstract class AbstractTree<T> implements Tree<T>{
     public BinaryTreeNode<T> root;

    private void preOrderRecursive(BinaryTreeNode<T> node ){
        if (node != null){
            System.out.println(node.data+ "");
            preOrderRecursive(node.leftChild);
            preOrderRecursive(node.rightChild);
        }
    }

    @Override
    public void preOrder() {
        preOrderRecursive(root);
    }

    private void  inOrderRecursive(BinaryTreeNode<T> node){
        if (node != null){
            inOrderRecursive(node.leftChild);
            System.out.println(node.data + "");
            inOrderRecursive(node.rightChild);
        }
    }

    //中序遍历
    public void inOrder() {
        inOrderRecursive(root);
    }

    private void postOrderRecursive(BinaryTreeNode<T> node){
        if (node!= null){
            preOrderRecursive(node.leftChild);
            preOrderRecursive(node.rightChild);
            System.out.println(node.data + " ");
        }
    }

    @Override
    public void postOrder() {
        postOrderRecursive(root);
    }

    @Override
    public void levelOrder() {
        final LinkedQueue<BinaryTreeNode<T>> queue = new LinkedQueue<>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            final BinaryTreeNode<T> node = queue.dequeue();
            System.out.println(node.data + " ");
            if (node.leftChild != null){
                queue.enqueue(node.leftChild);
            }
            if (node.rightChild != null){
                queue.enqueue(node.rightChild);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private int countRecursive(BinaryTreeNode<T> p){
        if (p == null) {
            return  0;
        }
        return countRecursive(p.leftChild) + countRecursive(p.rightChild) + 1;
    }

    @Override
    public int count() {
       return countRecursive(root);
    }

    private int  heightRecursive(BinaryTreeNode<T> p){
        if (p == null) {
            return 0;
        }
        return Math.max(heightRecursive(p.leftChild),heightRecursive(p.rightChild))+1;
    }

    @Override
    public int height() {
        return heightRecursive(root);
    }

    public void clear() {
        root  = null;
    }

}
