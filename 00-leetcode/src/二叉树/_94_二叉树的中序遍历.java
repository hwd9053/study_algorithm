package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else if (stack.isEmpty()) {
                return list;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }

    // 递归用list
    List<Integer> list = new ArrayList<>();
    // 递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return list;
        inorderTraversal2(root.left);
        list.add(root.val);
        inorderTraversal2(root.right);
        return list;
    }


}
