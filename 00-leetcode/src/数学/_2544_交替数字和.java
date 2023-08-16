package 数学;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/alternating-digit-sum/
 */
public class _2544_交替数字和 {
    public int alternateDigitSum(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }
        int ans = 0;
        boolean plus = true;
        while (!stack.isEmpty()) {
            if (plus) {
                ans += stack.pop();
                plus = false;
            } else {
                ans -= stack.pop();
                plus = true;
            }
        }

        return ans;
    }
}
