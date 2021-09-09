package 数组;

/**
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 */
public class _1588_所有奇数长度子数组的和 {
    // 前缀和
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int[] presum = new int[len + 1];
        int ans = 0;

        for (int i = 0; i < len; i++) {
            presum[i + 1] = presum[i] + arr[i];
        }

        for (int l = 0; l < len; l++) {
            for (int r = l; r < len; r+=2) {
                ans += presum[r + 1] - presum[l];
            }
        }

        return ans;
    }
}
