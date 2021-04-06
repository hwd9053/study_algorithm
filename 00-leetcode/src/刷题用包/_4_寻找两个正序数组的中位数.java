package 刷题用包;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if ((totalLength & 1) == 1) {
            int midIdx = totalLength >> 1;
            return getKthElement(nums1, nums2, midIdx + 1);
        } else {
            int midIdx1 = (totalLength >> 1) - 1, midIdx2 = midIdx1 + 1;
            return ((double) (getKthElement(nums1, nums2, midIdx1 + 1)
                    + getKthElement(nums1, nums2, midIdx2 + 1))) / 2;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int idx1 = 0, idx2 = 0;

        while (true) {
            if (idx1 == length1) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == length2) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) return Math.min(nums1[idx1], nums2[idx2]);

            int half = k >> 1;
            int newIdx1 = Math.min(length1, idx1 + half) - 1;
            int newIdx2 = Math.min(length2, idx2 + half) - 1;
            int pivot1 = nums1[newIdx1], pivot2 = nums2[newIdx2];

            if (pivot1 <= pivot2) {
                k -= newIdx1 - idx1 + 1;
                idx1 = newIdx1 + 1;
            } else {
                k -= newIdx2 - idx2 + 1;
                idx2 = newIdx2 + 1;
            }
        }
    }
}
