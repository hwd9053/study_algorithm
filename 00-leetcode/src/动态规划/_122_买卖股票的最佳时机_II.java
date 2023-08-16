package 动态规划;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class _122_买卖股票的最佳时机_II {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]: 第 i + 1 天，持有股票时的最大利益
        // dp[i][1]: 第 i + 1 天，不持有股票时的最大利益
        int[][] dp = new int[n][2];
        dp[0][0] = - prices[0];
//        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }
}
