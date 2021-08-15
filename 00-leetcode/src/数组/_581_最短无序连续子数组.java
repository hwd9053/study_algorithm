package 数组;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class _581_最短无序连续子数组 {
    // 跟 面试题16_16_部分排序 是同一题
    // 从左到右找逆序对，确定右边界
    // 从右到左再找逆序对，确定左边界
    public int findUnsortedSubarray(int[] nums) {
        int maxIdx = 0, minIdx = nums.length - 1;
        int rightIdx = 0, leftIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[maxIdx]) {
                maxIdx = i;
            } else {
                rightIdx = i;
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[minIdx]) {
                minIdx = i;
            } else {
                leftIdx = i;
            }
        }

        return rightIdx == leftIdx ? 0 : rightIdx - leftIdx + 1;
    }
}
