package com.tree.BinaryTree;

public class BinaryTree<T> implements BinaryTreeInter<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int count() {
        return count(this.root);
    }

    public int count(BinaryTreeNode<T> node) {
        if (node == null) return 0;
        return 1 + count(node.leftChild) + count(node.rightChild);
    }

    @Override
    public int height() {
        return height(this.root);
    }

    public int height(BinaryTreeNode<T> node) {
        if (node == null) return 0;
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    @Override
    public void preOrder(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.println(node.data.toString() + " ");
            postOrder(node.leftChild);
            postOrder(node.rightChild);
        }
    }

    @Override
    public void inOrder(BinaryTreeNode<T> node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node.data.toString() + " ");
            inOrder(node.rightChild);
        }
    }

    @Override
    public void postOrder(BinaryTreeNode<T> node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.data.toString() + " ");
        }
    }

    @Override
    public BinaryTreeNode<T> search(T key) {
        return search(this.root, key);
    }

    public BinaryTreeNode<T> search(BinaryTreeNode<T> p, T key) {
        if (p == null || key == null)
            return null;
        if (p.data.equals(key))
            return p;
        BinaryTreeNode<T> find = search(p.leftChild, key);
        if (find == null)
            find = search(p.rightChild, key);
        return find;
    }

    @Override
    public BinaryTreeNode<T> getParent(BinaryTreeNode<T> node) {
        if (root == null || node == null || node == root) return null;
        return getParent(this.root, node);
    }

    public BinaryTreeNode<T> getParent(BinaryTreeNode<T> p, BinaryTreeNode<T> node) {
        if (p == null || node == null) return null;
        if (p.leftChild == node || p.rightChild == node) return p;
        BinaryTreeNode<T> find = getParent(p.leftChild, node);
        if (find == null) return getParent(p.rightChild, node);
        return find;
    }

    @Override
    public void insertRoot(T x) {
        root = new BinaryTreeNode<T>(x, root, null);
    }

    @Override
    public BinaryTreeNode<T> insertChild(BinaryTreeNode<T> p, T x, boolean leftChild) {
        if (p == null || x == null) return null;
        if (leftChild) {
            p.leftChild = new BinaryTreeNode<T>(x, p.leftChild, null);
            return p.leftChild;
        }
        p.rightChild = new BinaryTreeNode<T>(x, p.rightChild, null);
        return p.rightChild;
    }

    @Override
    public void removeChild(BinaryTreeNode<T> p, boolean leftChild) {
        if (p != null) {
            if (leftChild)
                p.leftChild = null;
            else
                p.rightChild = null;
        }
    }

    @Override
    public void removeALl() {
    }

    public void clear(BinaryTreeNode node) {
        if (node != null) {
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node = null;
        }
    }

    public BinaryTreeNode<T> getLeftChild(BinaryTreeNode<T> node) {
        return node.getLeftChild();
    }

    public BinaryTreeNode<T> getRightChild(BinaryTreeNode<T> node) {
        return node.getRightChild();
    }

    public static void main(String[] args) {
        final BinaryTreeNode<Integer> binaryNode = new BinaryTreeNode<>(1, new BinaryTreeNode<Integer>(2), new BinaryTreeNode<Integer>(3));
        final BinaryTree<Integer> tree = new BinaryTree<>(binaryNode);
        final BinaryTreeNode<Integer> search = tree.search(1);
        System.out.println(tree.height());
        System.out.println( "root is  "+ tree.getRoot().data);
        System.out.println(search);
        tree.insertRoot(1);
    }
}
