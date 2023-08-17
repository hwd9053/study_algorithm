package 动态规划;

/**
 * https://leetcode-cn.com/problems/arithmetic-slices/
 */
public class _413_等差数列划分 {

    /**
     * https://leetcode-cn.com/problems/arithmetic-slices/solution/hua-dong-chuang-kou-dong-tai-gui-hua-jav-3vpp/
     * weiwei,yyds
     * 滑动窗口
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int ans = 0, left = 0, len = 0;

        int diff = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            // 不相等，意味着不能构成等差数列。即找到了当前的最长等差数列。
            // 根据其长度，更新结果
            if (nums[i] - nums[i - 1] != diff) {
                // 更新diff的值
                diff = nums[i] - nums[i - 1];
                // 计算等差数列的长度
                len = i - left;
                if (len >= 3) {
                    ans += (len - 2) * (len - 1) / 2;
                }
                left = i - 1;
            }
        }
        len = nums.length - left;
        if (len >= 3) ans += (len - 2) * (len - 1) / 2;

        return ans;
    }

    /**
     *  动态规划，空间可以优化。
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        int len = nums.length;
        if (len < 3) return 0;
        int ans = 0;
        // dp[i]: 以nums[i] 结尾的、且长度大于等于 3 的连续等差数列的个数
        int[] dp = new int[len];
        // dp[0], dp[1] = 0

        for (int i = 2; i < nums.length; i++) {
            // nums[i - 2] nums[i - 1] nums[i], 至少有3个数
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                // 状态转移方程
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7, 8, 9};
        System.out.println(new _413_等差数列划分().numberOfArithmeticSlices(nums));
    }

}
