package 二分;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        while (l <= r) { // 找左边界
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                res[0] = mid;
            }
            if (target <= nums[mid]) { // 相等时，依然往左边尝试寻找更小得左边界
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) { // 找右边界
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                res[1] = mid;
            }
            if (target >= nums[mid]) { // 相等时，依然往右边尝试寻找更大得右边界
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
