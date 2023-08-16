package 数组;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 */
public class _16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE, res = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去除重复计算
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == target) {
                    return sum;
                } else {
                    int diff = Math.abs(sum - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        res = sum;
                    } else if (sum > target) {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    } else {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
