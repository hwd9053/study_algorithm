package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class _62_不同路径 {
    public int uniquePaths(int m, int n) {
        // dp[i][j]:到达i+1,j+1格子的路径数
        int dp[][] = new int[m][n];

        dp[0][0] = 1;
        // 第0列初始化
        for (int row = 1; row < m; row++) {
            dp[row][0] = dp[row - 1][0];
        }

        // 第0行初始化
        for (int col = 1; col < n; col++) {
            dp[0][col] = dp[0][col - 1];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
