package 二叉树;

/**
 * https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/
 * https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/solutions/8726/hou-xu-bian-li-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class _1080_根到叶路径上的不足节点 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean bool = dfs(root, limit, 0);
        return bool ? root : null;
    }

    // 是否保留该节点
    private boolean dfs(TreeNode root, int limit, int sum) {
        int val = root.val + sum;
        if (root.left == null && root.right == null) {
            return val >= limit;
        }
        boolean left = false;
        if (root.left != null) {
            left = dfs(root.left, limit, val);
        }
        if (!left) root.left = null;

        boolean right = false;
        if (root.right != null) {
            right = dfs(root.right, limit, val);
        }
        if (!right) root.right = null;

        return left || right;
    }

}
