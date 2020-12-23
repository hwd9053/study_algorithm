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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);

        elements[size++] = element;
        siftUp(size - 1);
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    // 让index位置的元素上滤
    private void siftUp(int index) {
        while (index > 0) {

        }
    }

    private int compare(E e1, E e2) {
        return comparator != null ? comparator.compare(e1, e2)
                : ((Comparable<E>)e1).compareTo(e2);
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        // 如果现有容量可以满足要求，则直接返回
        if(oldCapacity >= capacity) return;

        // 如果现有容量不可以满足，则重新创建一个新数组

        // 新容量为旧容量的1.5倍(java的推荐？ios一般推荐1.6)
        // >>为位移操作(二进制操作),效率很高。右移1位，相当于除以2。为什么，可以自己想想看。
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        for(int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
}
