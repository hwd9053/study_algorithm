package 动态规划;

/**
 * https://leetcode.cn/problems/maximum-alternating-subsequence-sum/description/
 * https://leetcode.cn/problems/maximum-alternating-subsequence-sum/solutions/846529/zui-da-zi-xu-lie-jiao-ti-he-by-leetcode-epqrk/
 */
public class _1911_最大子序列交替和 {
    public long maxAlternatingSum(int[] nums) {
        // dp[i][0]: [0,i]范围内，子序列最后一个元素下标为偶数时的，最大交替和
        // dp[i][1]: [0,i]范围内，子序列最后一个元素下标为奇数时的，最大交替和
        int len = nums.length;
        long[][] dp = new long[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);
        }

        return dp[len - 1][0];
    }

    // 空间优化
    public long maxAlternatingSum2(int[] nums) {
        long even = nums[0], odd = 0;

        for (int i = 1; i < nums.length; i++) {
            long oldEven = even;
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, oldEven - nums[i]);
        }

        return even;
    }

    // dfs
    public long maxAlternatingSum3(int[] nums) {
        int n = nums.length;

        return dfs(nums, n - 1, 0);
    }

    private long dfs(int[] nums, int idx, int oddEven) {
        if (idx == 0) {
            return oddEven == 0 ? nums[0] : 0;
        }
        if (oddEven == 0) { // 最后一个数下标为偶数
            return Math.max(dfs(nums, idx - 1, 0), dfs(nums, idx - 1, 1) + nums[idx]);
        } else { // 奇数
            return Math.max(dfs(nums, idx - 1, 1), dfs(nums, idx - 1, 0) - nums[idx]);
        }
    }

}
