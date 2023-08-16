package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/reconstruct-a-2-row-binary-matrix/description/
 */
public class _1253_重构2行二进制矩阵 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> upList = new ArrayList<>();
        List<Integer> loList = new ArrayList<>();

        for (int i : colsum) {
            if (i == 2) {
                upper--;
                lower--;
                upList.add(1);
                loList.add(1);
            } else if (i == 1) {
                if (upper > lower) {
                    upper--;
                    upList.add(1);
                    loList.add(0);
                } else {
                    lower--;
                    upList.add(0);
                    loList.add(1);
                }
            } else {
                upList.add(0);
                loList.add(0);
            }
        }

        if (upper == 0 && lower == 0) {
            res.add(upList);
            res.add(loList);
        }

        return res;
    }
}
