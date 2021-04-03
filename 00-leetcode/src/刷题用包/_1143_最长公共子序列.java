package 刷题用包;

public class _1143_最长公共子序列 {
    // DP
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] cs1 = text1.toCharArray();
        char[] cs2 = text2.toCharArray();
        if (cs1.length == 0 || cs2.length == 0) return 0;

        // dp[i][j]:text1的前i个字符和text2的前j个字符的，最长公共子序列长度
        int[][] dp = new int[cs1.length + 1][cs2.length + 1];
        // 初期值:i为0时，值为0。j为0时，值为0。

        // 状态转移:cs1[i - 1] == cs2[j - 1]时，dp[i][j] = dp[i - 1][j - 1] + 1
        // 否则，dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[cs1.length][cs2.length];
    }
}
