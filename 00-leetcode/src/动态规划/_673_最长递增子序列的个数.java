package 动态规划;

/**
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/zui-chang-di-zeng-zi-xu-lie-de-ge-shu-by-w12f/
 */
public class _673_最长递增子序列的个数 {

    // DP
    public int findNumberOfLIS(int[] nums) {
        int ans = 1, maxLen = 1;
        // dp[i]: 以nums[i]结尾的，最长递增子序列的长度
        int[] dp = new int[nums.length];
        // cnt[i]: 以nums[i]结尾的，最长递增子序列的个数
        int[] cnt = new int[nums.length];
        dp[0] = 1;
        cnt[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            // 初期值均为1
            dp[i] = 1;
            cnt[i] = 1;

            // 找出当前i结尾的，最长序列长度以及个数
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    // 往前遍历时，发现了更长的序列
                    if (dp[j] + 1 > dp[i]) {
                        // 更新长度与个数
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        // 发现跟当前最大长度相等的序列
                        // 更新个数
                        cnt[i] += cnt[j];
                    }
                }
            }

            // 发现了更长的序列时，更新
            if (dp[i] > maxLen) {
                ans = cnt[i];
                maxLen = dp[i];
            } else if (dp[i] == maxLen) {
                // 发现与当前最长序列相同长度的序列时，更新ans
                ans += cnt[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,4,7};
        System.out.println(new _673_最长递增子序列的个数().findNumberOfLIS(nums));
    }
}
