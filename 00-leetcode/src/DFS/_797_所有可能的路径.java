package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/solution/gong-shui-san-xie-yun-yong-dfs-bao-sou-s-xlz9/
 */
public class _797_所有可能的路径 {
    // dfs
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        path.add(0);

        dfs(0, path, res, graph, target);

        return res;
    }

    /**
     * 深搜
     * @param vertex 顶点值
     * @param path   记录路径
     * @param res    结果集
     * @param graph  图
     * @param target 终点
     */
    private void dfs(int vertex, List<Integer> path, List<List<Integer>> res, int[][] graph, int target) {
        if (vertex == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i : graph[vertex]) {
            path.add(i);
            dfs(i, path, res, graph, target);
            path.remove(path.size() - 1);
        }

    }

}
