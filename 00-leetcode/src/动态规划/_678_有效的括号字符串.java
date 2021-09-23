package 动态规划;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 */
public class _678_有效的括号字符串 {
    // DP, 时间复杂度是O(n^3)
    public boolean checkValidString(String s) {
        char[] cs = s.toCharArray();
        // cs[i][j]: 下标i到j组成的字符串，是否为有效的括号字符串
        boolean[][] dp = new boolean[cs.length][cs.length];

        // 初期值，字串长度为1时，仅当当前字符为'*'时，结果为true
        for (int i = 0; i < dp.length; i++) {
            if (cs[i] == '*') {
                dp[i][i] = true;
            }
        }

        // 字符串长度为2时，仅当字符为"()", "*)", "(*", "**"时，结果为true
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = (cs[i] == '(' && (cs[i + 1] == ')' || cs[i + 1] == '*'))
                    || (cs[i] == '*' && (cs[i + 1] == ')' || cs[i + 1] == '*'));
        }

        // 字符长度大于2时，爬格子
        for (int i = dp.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < dp.length; j++) {
                // 下标为i+1到j-1组成的字符，是有效的括号字符串时
                if (dp[i + 1][j - 1]) {
                    dp[i][j] = (cs[i] == '(' || cs[i] == '*') && (cs[j] == ')' || cs[j] == '*');
                } else {
                    // 若存在i <= k < j, 满足[i, k]与[k + 1, j]均为有效括号字符串，则[i, j]也为有效
                    // 为啥是 < j, 可以考虑为，等于j时，k + 1就越界了
                    for (int k = i; k < j; k++) {
                        if (dp[i][k] && dp[k + 1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][cs.length - 1];
    }

    // 栈
    public boolean checkValidString2(String s) {
        // 用来存放左括号的坐标
        Deque<Integer> leftStack = new ArrayDeque<>();
        // 用来存放星号的坐标
        Deque<Integer> asteriskStack = new ArrayDeque<>();
        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            // 左括号，往左括号栈中存放
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                // 星号，往星号栈中存放
                asteriskStack.push(i);
            } else {
                // 右括号，优先用左括号做匹配
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }

        // 遍历结束后，处理栈中剩下的符号
        while (!leftStack.isEmpty()) {
            if (asteriskStack.isEmpty()) return false;
            if (leftStack.pop() > asteriskStack.pop()) return false;
        }

        return true;
    }

    // 贪心
    // https://leetcode-cn.com/problems/valid-parenthesis-string/solution/you-xiao-de-gua-hao-zi-fu-chuan-by-leetc-osi3/
    // https://leetcode-cn.com/problems/valid-parenthesis-string/solution/gong-shui-san-xie-yi-ti-shuang-jie-dong-801rq/
    public boolean checkValidString3(String s) {
        char[] cs = s.toCharArray();
        // 待匹配的左括号的最少数量以及最大数量
        int minCount = 0, maxCount = 0;

        for (char c : cs) {
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount--;
                maxCount--;
            } else {
                minCount--;
                maxCount++;
            }

            // 待匹配的左括号数量不应小于0
            minCount = Math.max(minCount, 0);
            // 若待匹配的最大的左括号数小于0，则说明匹配不下去了
            if (maxCount < 0) return false;
        }
        // 结束后，只有当最小值为0时，返回true
        return minCount == 0;
    }

}
