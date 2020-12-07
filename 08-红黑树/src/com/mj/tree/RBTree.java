package com.mj.tree;

import java.util.Comparator;

public class RBTree<E> extends BinarySearchTree<E>{

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        super.afterAdd(node);
    }

    @Override
    protected void afterRemove(Node<E> node) {
        super.afterRemove(node);
    }

    // 染色
    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) return null;
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    // 返回节点的颜色
    private boolean colorOf(Node<E> node) {
        // 红黑树的空节点，默认黑色
        return ((RBNode<E>)node) == null ? BLACK : ((RBNode<E>)node).color;
    }

    private static class RBNode<E> extends Node<E> {

        boolean color = RED;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }
}
