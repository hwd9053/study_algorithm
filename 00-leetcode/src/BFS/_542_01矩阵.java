package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/01-matrix/
 */
public class _542_01矩阵 {
    // bfs
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] mark = new boolean[m][n];
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    mark[i][j] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] coords = queue.poll();
            int x = coords[0], y = coords[1];
            int val = ans[x][y] + 1;

            if (x - 1 >= 0 && !mark[x - 1][y]) {
                ans[x - 1][y] = val;
                mark[x - 1][y] = true;
                queue.offer(new int[] {x - 1, y});
            }
            if (x + 1 < m && !mark[x + 1][y]) {
                ans[x + 1][y] = val;
                mark[x + 1][y] = true;
                queue.offer(new int[] {x + 1, y});
            }
            if (y - 1 >= 0 && !mark[x][y - 1]) {
                ans[x][y - 1] = val;
                mark[x][y - 1] = true;
                queue.offer(new int[] {x, y - 1});
            }
            if (y + 1 < n && !mark[x][y + 1]) {
                ans[x][y + 1] = val;
                mark[x][y + 1] = true;
                queue.offer(new int[] {x, y + 1});
            }
        }
        
        return ans;
    }

    // dp
    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp =  new int[m][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    dp[i][j] = 100000;
                }
            }
        }

        // dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1
        // 左上
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0) {
                    if (i - 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    if (j - 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        // dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
        // 右下
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] != 0) {
                    if (i + 1 < m) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    if (j + 1 < n) dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }

        return dp;
    }

}
