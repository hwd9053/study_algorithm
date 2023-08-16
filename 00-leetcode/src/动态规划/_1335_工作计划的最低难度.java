package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/description/
 */
public class _1335_工作计划的最低难度 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        // dp[i][j]: i项工作，j天
        int[][] dp = new int[n + 1][d + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 1 << 30);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= dp.length; i++) {
            for (int j = 1; j <= Math.min(i, d); j++) {
                int mx = 0;
                // k代表最后一天的选择。从第j项工作开始可以选择，到第i项工作。
                // 对应的job数组坐标为[j - 1, i - 1]
                // 这边从右往左遍历，方便求最后一次选择中难度最高的工作
                for (int k = i - 1; k >= j - 1 && k < n; k--) {
                    mx = Math.max(mx, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + mx);
                }
            }
        }
        return dp[n][d];
    }

    public static void main(String[] args) {
        _1335_工作计划的最低难度 v = new _1335_工作计划的最低难度();
        System.out.println(v.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
    }
}
