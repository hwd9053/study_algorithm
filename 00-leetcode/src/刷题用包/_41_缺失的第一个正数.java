package 刷题用包;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class _41_缺失的第一个正数 {
    // 原地交换
    public int firstMissingPositive(int[] nums) {
        // 值:i, 索引:i - 1
        for (int i = 0; i < nums.length; i++) {
            // 可以交换的nums[i]取值范围[1, nums.length]
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return nums.length + 1;
    }
}
