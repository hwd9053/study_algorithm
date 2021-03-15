package 栈_队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class _739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int topIdx = stack.pop();
                ans[topIdx] = i - topIdx;
            }
            stack.push(i);
        }
        return ans;
    }
}
