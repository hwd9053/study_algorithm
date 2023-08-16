package 动态规划;

/**
 * https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/
 */
public class _1186_删除一次得到子数组最大和 {
    public int maximumSum(int[] arr) {
        // dp[i][0]: 以arr[i]为结尾的，不删除元素情况下，子数组最大和
        // dp[i][1]: 以arr[i]为结尾的，删除一个元素情况下，子数组最大和
        int[][] dp = new int[arr.length][2];
        int res = arr[0];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }

        return res;
    }
    // 空间优化
    public int maximumSum2(int[] arr) {
        int f = arr[0], g = 0, res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            g = Math.max(f, g + arr[i]);
            f = Math.max(f + arr[i], arr[i]);

            res = Math.max(res, Math.max(f, g));
        }

        return res;
    }

}
