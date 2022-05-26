package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 */
public class _1380_矩阵中的幸运数 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minIdx = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < matrix[i][minIdx]) {
                    minIdx = j;
                }
            }

            boolean isMax = true;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][minIdx] > matrix[i][minIdx]) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                ans.add(matrix[i][minIdx]);
            }
        }

        return ans;
    }

    // 预处理
    public List<Integer> luckyNumbers2 (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int[] minRow = new int[matrix.length];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minRow[i]) {
                    minRow[i] = matrix[i][j];
                }
                if (matrix[i][j] > maxCol[j]) {
                    maxCol[j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}
