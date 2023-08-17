package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/univalued-binary-tree/
 */
public class _965_单值二叉树 {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return preorderTraversal(root.left, val) && preorderTraversal(root.right, val);
    }

    private boolean preorderTraversal(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return preorderTraversal(root.left, val) && preorderTraversal(root.right, val);
    }

    public boolean isUnivalTree2(TreeNode root) {
        if (root.left != null && (root.val != root.left.val || !isUnivalTree2(root.left))) {
            return false;
        }
        if (root.right != null && (root.val != root.right.val || !isUnivalTree2(root.right))) {
            return false;
        }

        return true;
    }

    public boolean isUnivalTree3(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int val = root.val;

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.val != val) return false;
            if (treeNode.left != null) queue.offer(treeNode.left);
            if (treeNode.right != null) queue.offer(treeNode.right);
        }

        return true;
    }

}
