package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/flood-fill/description/?company_slug=microsoft
 */
public class _733_图像渲染 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        int origin = image[sr][sc];
        if (origin == color) return image;

        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            int x = coord[0], y = coord[1];
            image[x][y] = color;
            if (x - 1 >= 0 && image[x - 1][y] == origin) {
                image[x - 1][y] = color;
                queue.offer(new int[] {x - 1, y});
            }
            if (x + 1 < image.length && image[x + 1][y] == origin) {
                image[x + 1][y] = color;
                queue.offer(new int[] {x + 1, y});
            }
            if (y - 1 >= 0 && image[x][y - 1] == origin) {
                image[x][y - 1] = color;
                queue.offer(new int[] {x, y - 1});
            }
            if (y + 1 < image[0].length && image[x][y + 1] == origin) {
                image[x][y + 1] = color;
                queue.offer(new int[] {x, y + 1});
            }
        }

        return image;
    }
}
