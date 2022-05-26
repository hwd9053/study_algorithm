package 数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class _1984_学生分数的最小差值 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE, lastIdx = nums.length - k;
        for (int i = 0; i <= lastIdx; i++) {
            int diff = nums[i + k - 1] - nums[i];
            if (diff < ans) {
                ans = diff;
            }
        }

        return ans;
    }
}
