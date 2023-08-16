package 二叉树;

/**
 * https://leetcode.cn/problems/distribute-coins-in-binary-tree/description/
 * https://leetcode.cn/problems/distribute-coins-in-binary-tree/solutions/2343262/tu-jie-mei-you-si-lu-jin-lai-miao-dong-p-vrni/
 */
public class _979_在二叉树中分配硬币 {
    private int ans;
    // 思路是边。
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 统计每颗子树的硬币数以及节点数
    // 后续
    private int[] dfs2(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = dfs2(root.left);
        int[] right = dfs2(root.right);
        int coins = left[0] + right[0] + root.val;
        int nodes = left[1] + right[1] + 1;

        ans += Math.abs(coins - nodes);

        return new int[] {coins, nodes};
    }

    // 定义返回值 d = d(left) + d(right) + node.val - 1;
    // d其实就是每条边的计数器。每颗子树不足或者多余的硬币
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int d = dfs(root.left) + dfs(root.right) + root.val - 1;

        ans += Math.abs(d);

        return d;
    }
}
