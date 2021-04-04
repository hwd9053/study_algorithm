package 刷题用包;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break/
 */
public class _139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] cs = s.toCharArray();
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[cs.length + 1];
        // s长度为0时，true
        dp[0] = true;

        for (int i = 1; i <= cs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(new String(cs, j, i - j)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[cs.length];
    }
}
