package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-n-ary-tree/
 * https://leetcode-cn.com/problems/serialize-and-deserialize-n-ary-tree/solution/shi-yong-stack-ji-lu-mei-yi-ge-fu-jie-dian-dfs-by-/
 */
public class _428_序列化和反序列化_N_叉树 {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            encode(root, sb);
            return sb.toString();
        }

        private void encode(Node root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(",");
            if (root.children != null) {
                sb.append("[,");
                for (Node child : root.children) {
                    encode(child, sb);
                }
                sb.append("],");
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            String[] strings = data.split(",");
            Deque<Node> stack = new ArrayDeque<>();
            Node root = null;
            Node cur = null;

            for (String string : strings) {
                if (string.equals("[")) {
                    // 遇到左括号，cur入栈，cur是接下来[]内元素的父节点
                    stack.push(cur);
                } else if (string.equals("]")) {
                    // 遇到右括号，表明当前父节点的字节点已添加完毕，故出栈
                    stack.pop();
                } else {
                    Node node = new Node(Integer.parseInt(string));
                    node.children = new LinkedList<>();

                    if (root == null) {
                        root = node;
                    } else {
                        Node parent = stack.peek();
                        parent.children.add(node);
                    }
                    cur = node;
                }
            }
            return root;
        }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        _428_序列化和反序列化_N_叉树 test = new _428_序列化和反序列化_N_叉树();
        Node root = new Node(1);
        Node node3 = new Node(3);
        List<Node> list = new ArrayList<>();
        list.add(new Node(5));
        list.add(new Node(6));
        node3.children = list;
        list = new ArrayList<>();
        root.children = list;
        list.add(node3);
        list.add(new Node(2));
        list.add(new Node(4));
        System.out.println(test.serialize(root));
    }
}
