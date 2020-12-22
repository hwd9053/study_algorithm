package com.mj.heap;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class BinaryHeap<E> implements Heap<E> {

    private E[] elements;
    private int size;
    private Comparator<E> comparator; // 二叉堆要求元素具有可比较性

    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        this(null);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(E element) {

    }

    @Override
    public E get() {
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    private int compare(E e1, E e2) {
        return comparator != null ? comparator.compare(e1, e2)
                : ((Comparable<E>)e1).compareTo(e2);
    }
}
