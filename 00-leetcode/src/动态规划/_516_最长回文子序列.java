package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class _516_最长回文子序列 {

    /**
     * https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/dong-tai-gui-hua-si-yao-su-by-a380922457-3/
     * 动态规划。跟以前做的最长公共子序列很像
     * 动态规划，暴力循环+记事本
     */
    public int longestPalindromeSubseq(String s) {
        char[] cs = s.toCharArray();
        if (cs.length == 0 || cs.length == 1) return cs.length;
        // dp[i][j]: 表示字符串s的i位置到j位置的，最长回文子序列长度
        int[][] dp = new int[cs.length][cs.length];

        for (int i = cs.length - 1; i >= 0; i--) {
            // 单个字符的回文子序列长度为1
            dp[i][i] = 1;
            for (int j = i + 1; j < cs.length; j++) {
                // 若i, j位置的字符相等
                if (cs[i] == cs[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 不等, 则取较大的一方
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][cs.length - 1];
    }

}
