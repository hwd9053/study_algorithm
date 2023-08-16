package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sum/
 */
public class _18_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
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

        return ans;
    }
}
