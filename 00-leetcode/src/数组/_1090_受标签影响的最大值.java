package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/largest-values-from-labels/description/
 */
public class _1090_受标签影响的最大值 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] id = new Integer[n]; // 用来记录数组下标
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

        Arrays.sort(id, (a, b) -> values[b] - values[a]);

        Map<Integer, Integer> cnts = new HashMap<>();
        int ans = 0, choose = 0;

        for (Integer idx : id) {
            int cnt = cnts.getOrDefault(labels[idx], 0);
            if (cnt < useLimit) {
                ans += values[idx];
                cnts.put(labels[idx], ++cnt);
                if (++choose == numWanted) break;
            }
        }

        return ans;
    }
}
