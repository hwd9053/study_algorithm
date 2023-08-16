package 数学;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/maximum-split-of-positive-even-integers/description/
 */
public class _2178_拆分成最多数目的正偶数之和 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) return res;

        for (long i = 2; i <= finalSum; i += 2) {
            finalSum -= i;
            res.add(i);
        }
        int lastIdx = res.size() - 1;
        res.set(lastIdx, res.get(lastIdx) + finalSum);
        return res;
    }
}
