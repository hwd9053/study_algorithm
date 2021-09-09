package 数组;

/**
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 */
public class _1109_航班预订统计 {
    // 暴力
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] booking : bookings) {
            for (int j = booking[0] - 1; j < booking[1]; j++) {
                ans[j] += booking[2];
            }
        }

        return ans;
    }

    // 差分数组 + 前缀和
    // https://leetcode-cn.com/problems/corporate-flight-bookings/solution/tong-ge-lai-shua-ti-la-yi-ti-liang-jie-t-0qse/
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2];
            if (booking[1] == n) continue;
            ans[booking[1]] -= booking[2];
        }

        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}
