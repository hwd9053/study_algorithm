package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class _1190_反转每对括号间的子串 {
    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        char[] cs = s.toCharArray();

        for (char c : cs) {
            if (c != ')') {
                stack.push(c);
            } else {
                while (stack.peek() != '(') {
                    stack2.push(stack.pop());
                }
                stack.pop();
                while (!stack2.isEmpty()) {
                    stack.push(stack2.poll());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
