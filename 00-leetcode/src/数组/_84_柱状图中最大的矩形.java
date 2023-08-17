package 数组;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class _84_柱状图中最大的矩形 {

    // 暴力，超时了
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int ri = i + 1;
            int li = i - 1;
            while (ri < heights.length && heights[ri] >= heights[i]) {
                ri++;
            }
            while (li >= 0 && heights[li] >= heights[i]) {
                li--;
            }

            int len = ri - li - 1;
            ans = Math.max(ans, heights[i] * len);
        }
        return ans;
    }

    // 单调栈
    // https://leetcode.cn/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/ Fomalhaut的评论
    // https://leetcode.cn/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/ weiwei大佬
    public int largestRectangleArea2(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        int len = heights.length + 2;
        int[] newHeights = new int[len];
        newHeights[0] = newHeights[len - 1] = 0;

        for (int i = 1; i < len - 1; i++) {
            newHeights[i] = heights[i - 1];
        }

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int cur = stack.pop();
                ans = Math.max(ans, (i - stack.peek() - 1) * newHeights[cur]);
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _84_柱状图中最大的矩形().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
