package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class _300_最长递增子序列 {

    // dp
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
