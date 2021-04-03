package 刷题用包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class _56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (!list.isEmpty() && list.get(list.size() - 1)[1] >= interval[0]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            } else {
                list.add(interval);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
        int[][] ans = new int[intervals.length][2];

        int idx = -1;
        for (int[] interval : intervals) {
            if (idx != -1 && interval[0] <= ans[idx][1]) {
                ans[idx][1] = Math.max(ans[idx][1], interval[1]);
            } else {
                ans[++idx] = interval;
            }
        }

        return Arrays.copyOf(ans, idx + 1);
    }
}
