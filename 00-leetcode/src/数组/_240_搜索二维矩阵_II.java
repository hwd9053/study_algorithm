package 数组;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class _240_搜索二维矩阵_II {
    // 面试的时候写的笨二分
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int colLen = matrix[0].length - 1;
        for (int row = 0; row < matrix.length; row++) {
            if (target >= matrix[row][0] && target <= matrix[row][colLen]) {
                int li = 0, ri = colLen;
                while (li <= ri) {
                    int mid = li + (ri - li) / 2;
                    if (matrix[row][mid] > target) {
                        ri = mid - 1;
                    } else if (matrix[row][mid] < target) {
                        li = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-iicong-ju-zhen-de-ktzv/
    // 从左下角开始找。要学会多观察。思路不是固定的。
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
