package 动态规划;

// 0-1背包
public class Knapsack {

    public int maxValue(int[] values, int[] weights, int capacity) {
        // dp[i][j] : 前i件物品可选，最大重量为j时候的，最大价值
        int[][] dp = new int[values.length + 1][capacity + 1];

        // dp[0][j] = 0
        // dp[i][0] = 0

        // weights[i - 1] <= capacity时
        // 可选当前物品。dp[i][j] = max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j])
        // 否则，当前物品不可选。dp[i][j] = dp[i - 1][j]
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[values.length][capacity];
    }

    public static void main(String[] args) {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        int capacity = 10;
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.maxValue(values, weights, capacity));
    }

}
