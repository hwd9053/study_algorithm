package 动态规划;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class _583_两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        // dp[i][j]: word1的前i个字符和word2的前j个字符的最小删除步数
        int[][] dp = new int[cs1.length + 1][cs2.length + 1];

        for (int i = 1; i <= cs2.length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= cs1.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    // 相等，无需删除
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不等，取较小的值+1
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[cs1.length][cs2.length];
    }
}
