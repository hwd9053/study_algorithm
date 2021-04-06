package 刷题用包;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class _146_LRU_缓存机制 {
    class LRUCache {
        int capacity;
        Node first;
        Node last;
        Map<Integer, Node> map;
        int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            first = new Node(0, 0);
            last = new Node(0, 0);
            first.next = last;
            last.prev = first;
            map = new HashMap<>();
            size = 0;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            node.prev.next = node.next;
            node.next.prev = node.prev;

            first.next.prev = node;
            node.next = first.next;
            first.next = node;
            node.prev = first;

            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else {
                if (size == capacity) {
                    map.remove(last.prev.key);
                    last.prev.prev.next = last;
                    last.prev = last.prev.prev;
                } else {
                    size++;
                }
                node = new Node(key, value);
            }
            first.next.prev = node;
            node.next = first.next;
            first.next = node;
            node.prev = first;
            map.put(key, node);
        }
    }

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
