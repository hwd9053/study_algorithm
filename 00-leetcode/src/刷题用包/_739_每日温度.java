package 刷题用包;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class _739_每日温度 {
    // 单调栈
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int topIdx = stack.pop();
                res[topIdx] = i - topIdx;
            }
            stack.push(i);
        }
        return res;
    }

    // DP
    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];

        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {
                    ans[i] = j - i;
                    break;
                } else if (ans[j] == 0) {
                    ans[i] = 0;
                    break;
                } else {
                    j = j + ans[j];
                }
            }
        }

        return ans;
    }
}
