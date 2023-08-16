package 二分;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class _153_寻找旋转排序数组中的最小值 {
    // 二分法好难理解啊！！
    // https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) { // 右边升顺，右侧可以缩掉
                r = mid;
            } else { // 右侧无序，表示最小值在右边，缩左边
                l = mid + 1;
            }
        }

        return nums[l];
    }

}
