package 刷题用包;

public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (target == nums[mid]) return mid;
            // 前半有序
            if (nums[begin] <= nums[mid]) {
                if (target >= nums[begin] && target < nums[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            } else { // 后半有序
                if (target > nums[mid] && target <= nums[end - 1]) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }
}
