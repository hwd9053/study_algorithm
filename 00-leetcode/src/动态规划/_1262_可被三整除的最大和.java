package 动态规划;

/**
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/
 */
public class _1262_可被三整除的最大和 {
    public int maxSumDivThree(int[] nums) {
        // dp[i][j]: nums前i个数，mod 3余数为j时的最大和
        int[][] dp = new int[nums.length + 1][3];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                // 可以不选，也可以选。
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(j + 3 - nums[i - 1] % 3) % 3] + nums[i - 1]);
            }
        }

        return dp[nums.length][0];
    }

    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};
        System.out.println(new _1262_可被三整除的最大和().maxSumDivThree(nums));
    }
}
