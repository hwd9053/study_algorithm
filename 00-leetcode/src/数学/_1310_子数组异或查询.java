package 数学;

/**
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 */
public class _1310_子数组异或查询 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = preSum[queries[i][0]] ^ preSum[queries[i][1]] ^ arr[queries[i][0]];
        }

        return ans;
    }
}
