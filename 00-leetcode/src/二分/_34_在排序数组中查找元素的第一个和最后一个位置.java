package 二分;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange2(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) return ans;
        int li = 0, ri = nums.length - 1;

        // 左边界
        while (li < ri) {
            int mid = (li + ri) / 2;
            if (target <= nums[mid]) {
                ri = mid;
            } else {
                li = mid + 1;
            }
        }

        if (nums[li] != target) return ans;
        ans[0] = li;

        li = 0;
        ri = nums.length - 1;
        // 右边界
        while (li < ri) {
            // 注意，li = mid的时候，mid要+1; 不然会死循环！！
            int mid = (li + ri + 1) / 2;
            if (target >= nums[mid]) {
                li = mid;
            } else {
                ri = mid - 1;
            }
        }
        ans[1] = ri;

        return ans;
    }

    public int[] searchRange(int[] nums, int target) throws InterruptedException {
        int l = 0, r = nums.length - 1;
        int[] ans = new int[] {-1, -1};
        // 寻找左边界
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                ans[0] = mid;
                r = mid - 1;
                if (mid == 0 || nums[mid - 1] != target) break;
            }
        }

        if (ans[0] == -1) return ans;

        l = 0;
        r = nums.length - 1;

        // 寻找右边界
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                ans[1] = mid;
                l = mid + 1;
                if (mid == nums.length - 1 || nums[mid + 1] != target) break;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[] {5,7,7,8,8,10};
        new _34_在排序数组中查找元素的第一个和最后一个位置().searchRange(nums, 8);
    }
}
