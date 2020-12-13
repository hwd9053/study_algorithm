package com.mj.map;

import com.mj.tree.BinaryTree;

import java.util.Comparator;

public class TreeMap<K, V> implements Map<K, V>{
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private Comparator<K> comparator; // 比较器

    public TreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public TreeMap() {
        this(null);
    }

    protected int size;
    protected Node<K, V> root;

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
        root = null;
        size = 0;
    }

    /**
     *
     * @param key 键
     * @param value 值
     * @return 若有重复的键值对，返回被覆盖的键值对的值
     */
    @Override
    public V put(K key, V value) {
        keyNotNullCheck(key);
        // 添加第一个节点
        if(root == null) {
            root = new Node<>(key, value, null);
            size++;

            afterPut(root);
            return null;
        }
        Node<K, V> node = root;
        Node<K, V> parent = null;
        int cmp = 0;
        while(node != null) {
            cmp = compare(key, node.key);
            parent = node;
            if(cmp > 0) {
                node = node.right;
            } else if(cmp < 0) {
                node = node.left;
            } else { // 相等
                node.key = key;
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        Node<K, V> newNode = new Node<>(key, value, parent);
        if(cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        afterPut(newNode);
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {

    }

    private void keyNotNullCheck(K key) {
        if(key == null) {
            throw new IllegalArgumentException("key must not be null!");
        }
    }

    private void afterPut(Node<K, V> node) {

    }

    /**
     *
     * @return 返回值等于0，代表e1和e2相等。大于0，代表e1大于e2。小于0，代表e1小于e2
     */
    private int compare(K e1, K e2) {
        // 有比较器的话优先用比较器
        if(comparator != null) {
            return comparator.compare(e1, e2);
        }
        // 没有比较器的话，强转。如果强转失败，表示不可比较，而二叉搜索树的元素，必须可以比较。
        return ((Comparable<K>)e1).compareTo(e2);
    }

    public static class Node<K, V> {
        K key;
        V value;
        boolean color = RED;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;
        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return (left == null && right == null);
        }

        public boolean hasTwoChildren() {
            return (left != null && right != null);
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        // 返回兄弟节点
        public Node<K, V> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }

            if (isRightChild()) {
                return parent.left;
            }

            // 没有父节点，则没有兄弟节点
            return null;
        }
    }
}
