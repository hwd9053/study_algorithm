package 二叉树;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
 */
public class _124_二叉树中的最大路径和 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 左右子树的最大值才能向父节点贡献
        int val = root.val + Math.max(left, right);
        // 更新最大值
        ans = Math.max(ans, root.val + left + right);

        return Math.max(val, 0);
    }
}
