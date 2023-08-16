package 数组;

/**
 * https://leetcode.cn/problems/matrix-diagonal-sum/
 */
public class _1572_矩阵对角线元素的和 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans + mat[i][i] + mat[i][n - i - 1];
        }

        return ans - (n & 1) * mat[n / 2][n / 2];
    }
}
