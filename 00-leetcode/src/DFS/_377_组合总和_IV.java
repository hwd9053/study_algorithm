package DFS;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/gong-shui-san-xie-yu-wan-quan-bei-bao-we-x0kn/
 */
public class _377_组合总和_IV {

    public int combinationSum4(int[] nums, int target) {
        // dp[i][j] : 组合长度为i,target为j时候的,方案数
        // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
        int[][] dp = new int[target + 1][target + 1];
        // dp[0][0] = 1
        dp[0][0] = 1;

        int ans = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j <= target; j++) {
                for (int num : nums) {
                    if (num <= j) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }
            ans += dp[i][target];
        }
        return ans;
    }

    // 空间优化为一维数组
    public int combinationSum4_2(int[] nums, int target) {
        // dp[i] : 目标数为i时的组合数
        int[] dp = new int[target + 1];
        // 目标数为0时，只有一种组合数，就是啥都不选
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
