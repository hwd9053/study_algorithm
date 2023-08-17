package 动态规划;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 */
public class _152_乘积最大子数组 {
    // 动态规划。统计最大与最小
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int ans = nums[0];

        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], nums[i]), min[i - 1] * nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], nums[i]), min[i - 1] * nums[i]);
            ans = Math.max(ans, max[i]);
        }

        return ans;
    }

    // 优化空间
    public int maxProduct2(int[] nums) {
        int preMax = nums[0], preMin = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = preMax;
            preMax = Math.max(Math.max(nums[i], preMax * nums[i]), preMin * nums[i]);
            preMin = Math.min(Math.min(nums[i], temp * nums[i]), preMin * nums[i]);
            ans = Math.max(ans, preMax);
        }

        return ans;
    }

    // 再进一步优化。。
    public int maxProduct3(int[] nums) {
        int preMax = nums[0], preMin = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            if (nums[i] < 0) {
                int tmp = preMax;
                preMax = preMin;
                preMin = tmp;
            }
            preMax = Math.max(nums[i], nums[i] * preMax);
            preMin = Math.min(nums[i], nums[i] * preMin);
            ans = Math.max(ans, preMax);
        }

        return ans;
    }

}
