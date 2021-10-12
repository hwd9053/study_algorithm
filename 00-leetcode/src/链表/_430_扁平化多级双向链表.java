package 链表;

/**
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/gong-shui-san-xie-yi-ti-shuang-jie-di-gu-9wfz/
 */
public class _430_扁平化多级双向链表 {
    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node next = node.next;
                node.next = flatten(node.child);
                node.next.prev = node;
                node.child = null;
                while (node.next != null) {
                    node = node.next;
                }
                if (next != null) {
                    node.next = next;
                    next.prev = node;
                }
            }
            node = node.next;
        }
        return head;
    }

    // https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/bian-ping-hua-duo-ji-shuang-xiang-lian-b-383h/
    public Node flatten2(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node cur = node;
        Node last = null;

        while (cur != null) {
            Node next = cur.next;
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }

        return last;
    }
}
