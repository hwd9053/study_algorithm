package 二叉树;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/bfsjie-jue-zui-hao-de-ji-bai-liao-100de-yong-hu-by/
 */
public class _117_填充每个节点的下一个右侧节点指针_II {
    public Node connect(Node root) {
        if (root == null) return null;

        Node pre = root;
        while (pre != null) {
            Node parent = pre;
            Node dummy = new Node();
            Node cur = dummy;
            while (parent != null) {
                if (parent.left != null) {
                    cur.next = parent.left;
                    cur = cur.next;
                }
                if (parent.right != null) {
                    cur.next = parent.right;
                    cur = cur.next;
                }
                parent = parent.next;
            }
            pre = dummy.next;
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
