package 数组;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/ipo/
 */
public class _502_IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }

        // 按照capital从小到大排序
        Arrays.sort(arr, (x, y) -> x[1] - y[1]);
        // 构建利益的大顶堆，满足本金要求的项目，都放入大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int cur = 0;
        // 循环k次。
        for (int i = 0; i < k; i++) {
            // 本金小于等于w的，都放入堆中
            for (; cur < n && arr[cur][1] <= w; cur++) {
                queue.offer(arr[cur][0]);
            }
            // 若堆为空，说明没有符合条件的
            if (queue.isEmpty()) break;
            // 计算利润
            w += queue.poll();
        }

        return w;
    }
}
