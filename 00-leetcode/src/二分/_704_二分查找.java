package 二分;

/**
 * https://leetcode-cn.com/problems/binary-search/
 */
public class _704_二分查找 {
    public int search(int[] nums, int target) throws InterruptedException {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
