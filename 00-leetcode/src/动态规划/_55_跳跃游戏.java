package 动态规划;

/**
 * https://leetcode.cn/problems/jump-game/
 */
public class _55_跳跃游戏 {
    // 蠢蠢的dp
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                if (i + nums[i] >= nums.length) {
                    return true;
                } else {
                    if (dp[i + nums[i]]) {
                        continue;
                    }
                }
                for (int j = 1; j <= nums[i] && (i + j < nums.length); j++) {
                    dp[i + j] = true;
                }
            } else {
                return false;
            }
        }

        return dp[nums.length - 1];
    }

    // 贪心
    public boolean canJump2(int[] nums) {
        int rightMost = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost= Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) return true;
            } else {
                return false;
            }
        }

        return true;
    }
}
