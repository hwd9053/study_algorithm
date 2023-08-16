package 图;

import java.util.*;

/**
 * https://leetcode.cn/problems/parallel-courses-iii/
 */
public class _2050_并行课程_III {
    // 拓扑排序
    public int minimumTime(int n, int[][] relations, int[] time) {
        // 构建邻接表(图)
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, value -> new ArrayList<>());
        // 统计入度
        int[] deg = new int[n];

        for (int[] r : relations) {
            graph[r[0] - 1].add(r[1] - 1);
            // 后继课程入度+1
            deg[r[1] - 1]++;
        }

        // 拓扑排序用队列
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < deg.length; i++) {
            // 入度为0的入队
            if (deg[i] == 0) queue.offer(i);
        }
        
        int ans = 0;
        // 每门课所花最少时间
        int[] f = new int[n];
        
        // 拓扑排序
        while (!queue.isEmpty()) {
            Integer prevClass = queue.poll();
            f[prevClass] += time[prevClass];
            ans = Math.max(ans, f[prevClass]);
            for (Integer succeedClass : graph[prevClass]) {
                // 前继课程中取最大值
                f[succeedClass] = Math.max(f[succeedClass], f[prevClass]);
                // 入度-1, 入度为0的入队
                if (--deg[succeedClass] == 0) queue.offer(succeedClass);
            }
        }

        return ans;
    }

    // 记忆化搜索
    public int minimumTime2(int n, int[][] relations, int[] time) {
        List<Integer>[] prev = new List[n];
        Arrays.setAll(prev, v -> new ArrayList<>());

        for (int[] r : relations) {
            int x = r[0] - 1, y = r[1] - 1;
            prev[y].add(x);
        }

        int ans = 0;
        Map<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp(i, prev, time, memo));
        }

        return ans;
    }

    private int dp(int i, List<Integer>[] prev, int[] time, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) return memo.get(i);
        int cur = 0;
        for (Integer pre : prev[i]) {
            cur = Math.max(cur, dp(pre, prev, time, memo));
        }
        cur += time[i];
        memo.put(i, cur);
        return cur;
    }

    public static void main(String[] args) {
        new _2050_并行课程_III().minimumTime(9, new int[][]{{1},{2}}, new int[] {1,1});
    }
}
