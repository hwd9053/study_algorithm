package 数组;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/minimum-interval-to-include-each-query/
 * https://leetcode.cn/problems/minimum-interval-to-include-each-query/solutions/755827/javayou-xian-ji-dui-lie-jie-ti-qian-xian-v4s6/
 */
public class _1851_包含每个查询的最小区间 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // interval按照左端排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int n = queries.length;
        int[][] qes = new int[n][2];

        for (int i = 0; i < n; i++) {
            qes[i][0] = queries[i];
            qes[i][1] = i;
        }
        // query按照数值大小排序
        Arrays.sort(qes, (o1, o2) -> o1[0] - o2[0]);

        int index = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o1[0] + o2[0] - o2[1]);
        for (int i = 0; i < n; i++) {
            while (index < intervals.length && qes[i][0] >= intervals[index][0]) {
                queue.offer(new int[] {intervals[index][0], intervals[index][1]});
                index++;
            }

            while (!queue.isEmpty() && queue.peek()[1] < qes[i][0]) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                int[] peek = queue.peek();
                ans[qes[i][1]] = peek[1] - peek[0] + 1;
            }
        }
        return ans;
    }
}
