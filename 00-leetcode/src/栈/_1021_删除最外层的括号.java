package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class _1021_删除最外层的括号 {
    // 还可以不用栈，只用一个int来记录层数
    public String removeOuterParentheses(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        // 注意，这里面的括号都是能匹配上的
        for (int i = 0; i < cs.length; i++) {
            // 右括号，出栈
            if (cs[i] == ')') {
                stack.pop();
            }
            // 栈不为空，就拼接
            if (!stack.isEmpty()) {
                sb.append(cs[i]);
            }
            // 左括号，入栈
            if (cs[i] == '(') {
                stack.push(cs[i]);
            }
        }

        return sb.toString();
    }

    public String removeOuterParentheses2(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        // 注意，这里面的括号都是能匹配上的
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                // 仅在栈不为空的时候拼接(因为要去掉外层)
                if (!stack.isEmpty()) {
                    sb.append(cs[i]);
                }
                stack.push(cs[i]);
            } else {
                stack.pop();
                // 仅在栈不为空的时候拼接(因为要去掉外层)
                if (!stack.isEmpty()) {
                    sb.append(cs[i]);
                }
            }
        }

        return sb.toString();
    }
}
