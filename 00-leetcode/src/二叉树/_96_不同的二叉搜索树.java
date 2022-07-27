package 二叉树;

/**
 * https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class _96_不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 根节点从1开始，到i
            for (int j = 1; j <= i; j++) {
                // 根节点左边有j-1个节点比根节点小[1, j)
                // 右边有i - j个节点比根节点大(j, i]
                dp[i] += (dp[j - 1] * dp[i - j]);
            }
        }

        return dp[n];
    }
}
