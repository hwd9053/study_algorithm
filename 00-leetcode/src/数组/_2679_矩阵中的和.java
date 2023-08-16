package 数组;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sum-in-a-matrix/description/
 */
public class _2679_矩阵中的和 {
    public int matrixSum(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        for (int[] num : nums) {
            Arrays.sort(num) ;
        }

        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int maxScore = 0;
            for (int[] num : nums) {
                maxScore = Math.max(maxScore, num[i]);
            }
            res += maxScore;
        }

        return res;
    }
}
