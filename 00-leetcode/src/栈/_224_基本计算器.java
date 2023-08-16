package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class _224_基本计算器 {
    // 核心思想是，遇到左括号，把当前计算结果以及符号位入栈保存起来
    // 遇到右括号，栈顶元素出栈，与当前计算出来的值进行计算
    // https://leetcode-cn.com/problems/basic-calculator/solution/shuang-zhan-shuang-90-by-cyingenohalt-eoy3/
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        Stack<Integer> nums = new Stack<>();
        Stack<Integer> ops = new Stack<>();
        int ans = 0; // 存放最终结果
        int sign = 1; // 存放当前运算的符号
        for (int i = 0; i < cs.length; i++) {
            // 遇到空格，跳过
            if (cs[i] == ' ') continue;
            // 遇到符号，更新当前运算的符号
            if (cs[i] == '+') {
                sign = 1;
                continue;
            }
            if (cs[i] == '-') {
                sign = -1;
                continue;
            }
            // 遇到数字，进行计算
            if (Character.isDigit(cs[i])) {
                int num = cs[i] - '0';
                while (i < cs.length - 1 && Character.isDigit(cs[i + 1])) {
                    num = num * 10 + (cs[++i] - '0');
                }
                ans += sign * num;
            } else if (cs[i] == '(') { // 遇到左括号，把当前结果与符号往栈中存放，用来计算新的括号的结果
                nums.push(ans);
                ops.push(sign);
                ans = 0;
                sign = 1;
            } else { // 遇到右括号，出栈更新结果
                ans = ops.pop() * ans + nums.pop();
            }
        }
        return ans;
    }

    // https://leetcode.cn/problems/basic-calculator/solutions/2384893/javapython3czhan-zhan-kai-gua-hao-qiu-he-uu72/?company_slug=microsoft
    public int calculate2(String s) {
        Deque<Integer> stack = new ArrayDeque<>(); // 用来保存每一层的符号
        int sign = 1;
        stack.push(sign);
        int ans = 0, idx = 0;
        char[] cs = s.toCharArray();

        int n = cs.length;
        while (idx < n) {
            char c = cs[idx];
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (idx + 1 < n && Character.isDigit(cs[idx + 1])) {
                    num = num * 10 + (cs[++idx] - '0');
                }
                ans += sign * num;
            } else if (c == '+') {
                sign = stack.peek();
            } else if (c == '-') {
                sign = -stack.peek();
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            }
            idx++;
        }
        return ans;
    }
}
