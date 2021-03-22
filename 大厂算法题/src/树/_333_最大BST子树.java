package 树;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 */
public class _333_最大BST子树 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (isBST(root)) return nodesCount(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root) {
        return false;
    }

    private int nodesCount(TreeNode root) {
        return 0;
    }
}
