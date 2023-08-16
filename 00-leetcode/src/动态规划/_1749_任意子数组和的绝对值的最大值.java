package 动态规划;

/**
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/
 */
public class _1749_任意子数组和的绝对值的最大值 {
    // dp
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n], minDp = new int[n];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int ans = Math.max(Math.abs(maxDp[0]), Math.abs(minDp[0]));

        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = maxDp[i - 1] > 0 ? maxDp[i - 1] + nums[i] : nums[i];
            minDp[i] = minDp[i - 1] < 0 ? minDp[i - 1] + nums[i] : nums[i];
            ans = Math.max(ans, Math.max(Math.abs(maxDp[i]), Math.abs(minDp[i])));
        }

        return ans;
    }
    // dp + 空间优化
    public int maxAbsoluteSum2(int[] nums) {
        int max = nums[0] ,min = nums[0];
        int ans = Math.max(Math.abs(max), Math.abs(min));

        for (int i = 1; i < nums.length; i++) {
            max = max > 0 ? max + nums[i] : nums[i];
            min = min < 0 ? min + nums[i] : nums[i];
            ans = Math.max(ans, Math.max(Math.abs(max), Math.abs(min)));
        }

        return ans;
    }

    // 前缀和
    public int maxAbsoluteSum3(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int max = 0, min = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            max = Math.max(max, preSum[i + 1]);
            min = Math.min(min, preSum[i + 1]);
        }

        return max - min;
    }
}
