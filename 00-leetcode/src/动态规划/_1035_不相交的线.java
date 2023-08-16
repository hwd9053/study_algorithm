package 动态规划;

/**
 * https://leetcode-cn.com/problems/uncrossed-lines/
 */
public class _1035_不相交的线 {
    // 跟1143的LCS是差不多的题，但是没看出来。还是太菜了啊
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 定义状态，dp[i][j]表示nums1的前i个元素和nums2的前j个元素的最大连线数
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // 当然，dp[0][j]和dp[i][0]都为0

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
