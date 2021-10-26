package 二分;

/**
 * https://leetcode-cn.com/problems/B1IidL/
 */
public class _剑指_Offer_II_069_山峰数组的顶部 {
    // 想太复杂了。。mid跟mid + 1比就能知道左边或者右边哪边是单调的了
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[left] > arr[mid]) {
                right = mid - 1;
            } else if (arr[right] > arr[mid]) {
                left = mid + 1;
            } else {
                // mid比left和right都大
                if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                    left = mid + 1;
                } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }

        return left;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 0};
        System.out.println(new _剑指_Offer_II_069_山峰数组的顶部().peakIndexInMountainArray(arr));
    }
}
