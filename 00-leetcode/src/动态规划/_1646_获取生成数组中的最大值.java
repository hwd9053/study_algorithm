package 动态规划;

/**
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 */
public class _1646_获取生成数组中的最大值 {
    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        int res = 1;

        for(int i = 2; i <= n; i++) {
            int j = i / 2;
            if (i % 2 == 0) {
                dp[i] = dp[j];
            } else {
                dp[i] = dp[j] + dp[j + 1];
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new _1646_获取生成数组中的最大值().getMaximumGenerated(15);
        System.out.println(res);
    }
}
