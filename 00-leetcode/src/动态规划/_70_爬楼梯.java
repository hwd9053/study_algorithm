package 动态规划;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class _70_爬楼梯 {
    // DP,一维数组优化成两个变量
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int first = 1, second = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = second;
            second = first + second;
            first = tmp;
        }
        return second;
    }

    // 标准DP
    public int climbStairs2(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
