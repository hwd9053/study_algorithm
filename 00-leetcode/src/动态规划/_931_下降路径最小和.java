package 动态规划;

/**
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 */
public class _931_下降路径最小和 {
    // dp
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        // dp[i][j]: 下降到matrix[i][j]时的，最小下降路径和
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j + 1]), dp[i - 1][j - 1]) + matrix[i][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }

        return ans;
    }

    // dp + 空间优化
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        // dp[i][j]: 下降到matrix[i][j]时的，最小下降路径和
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            int pre = 0;
            for (int j = 0; j < n; j++) {
                int tmp = pre;
                pre = dp[j];
                if (j == 0) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + matrix[i][j];
                } else if (j == n - 1) {
                    dp[j] = Math.min(dp[j], tmp) + matrix[i][j];
                } else {
                    dp[j] = Math.min(Math.min(dp[j], dp[j + 1]), tmp) + matrix[i][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }
}
