package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/description/
 */
public class _1072_按列翻转得到最大值等行数 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> cnts = new HashMap<>();
        int n = matrix[0].length, res = 0;
        for (int[] row : matrix) {
            char[] cs = new char[n];
            for (int i = 0; i < row.length; i++) {
                // 异或的特性。0 ^ x = x, 1 ^ x = x取反
                // 每行开始第一个数要么是0，要么是1。0就保持原样，1就翻转
                cs[i] = (char) (row[0] ^ row[i]);
            }
            res = Math.max(res, cnts.merge(new String(cs), 1, Integer::sum));
        }

        return res;
    }
}
