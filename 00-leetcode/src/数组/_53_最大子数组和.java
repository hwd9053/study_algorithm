package 数组;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class _53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        // dp[i]: 以nums[i]为结尾的最大子序列和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        }

        int ans = nums[0];

        for (int num : dp) {
            ans = Math.max(ans, num);
        }

        return ans;
    }

    // 优化空间
    public int maxSubArray2(int[] nums) {
        int pre = nums[0];
        int ans = pre;

        for (int i = 1; i < nums.length; i++) {
            pre = pre > 0 ? pre + nums[i] : nums[i];
            ans = Math.max(pre, ans);
        }

        return ans;
    }

    // 分治
    // https://leetcode.cn/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
    public int maxSubArray3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int li, int ri) {
        if (li == ri) return nums[li];
        int mid = (li + ri) / 2;

        return max3(maxSubArray(nums,li, mid),
                    maxSubArray(nums,mid + 1, ri),
                    maxCrossSubArray(nums, li, ri, mid));
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }

    private int maxCrossSubArray(int[] nums, int li, int ri, int mid) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i = mid; i >= li; i--) {
            tempSum += nums[i];
            leftSum = Math.max(leftSum, tempSum);
        }

        tempSum = 0;
        for (int i = mid + 1; i <= ri; i++) {
            tempSum += nums[i];
            rightSum = Math.max(rightSum, tempSum);
        }
        return leftSum + rightSum;
    }


}
