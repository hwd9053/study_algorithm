package 动态规划;

/**
 * https://leetcode-cn.com/problems/student-attendance-record-ii/
 * https://leetcode-cn.com/problems/student-attendance-record-ii/solution/tong-ge-lai-shua-ti-la-yi-ti-liu-jie-dfs-s5fa/
 */
public class _552_学生出勤记录_II {

    int MOD = (int)1e9 + 7;

    // 暴力DFS
    public int checkRecord(int n) {
        return dfs(n, 0, 0);
    }

    // n: 剩余天数
    // ac: A的数量
    // lc: L的数量
    private int dfs(int n, int ac, int lc) {
        // 剩余天数为0，表示一条可以走的路
        if (n == 0) return 1;

        int ans = 0;

        if (ac == 0) {
            // 一次A都没有过，则可以选A
            ans += dfs(n - 1, 1, 0);
        }
        if (lc < 2) {
            // L只有0次或者1次，也可以选L
            ans += dfs(n - 1, ac, lc + 1);
        }
        // 任何状态都可以选P
        ans += dfs(n - 1, ac, 0);

        return ans;
    }

    // DFS + 记忆化搜索
    // 由于记忆化搜索，所以所有状态只会计算一次
    public int checkRecord2(int n) {
        // 三个维度分别代表[day, absent, late]
        int[][][] memo = new int[n + 1][2][3];
        return dfs2(n, 0, 0, memo);
    }

    // n: 剩余天数
    // ac: A的数量
    // lc: L的数量
    // memo记录了已经算过的状态
    private int dfs2(int n, int ac, int lc, int[][][] memo) {
        // 剩余天数为0，表示一条可以走的路
        if (n == 0) return 1;

        if (memo[n][ac][lc] != 0) {
            // 若这条路已经计算过，则无需再次计算！
            return memo[n][ac][lc];
        }

        int ans = 0;

        if (ac == 0) {
            // 一次A都没有过，则可以选A
            ans = (ans + dfs2(n - 1, 1, 0, memo)) % MOD;
        }
        if (lc < 2) {
            // L只有0次或者1次，也可以选L
            ans = (ans + dfs2(n - 1, ac, lc + 1, memo)) % MOD;
        }
        // 任何状态都可以选P
        ans = (ans + dfs2(n - 1, ac, 0, memo)) % MOD;

        // 记录状态！
        memo[n][ac][lc] = ans;

        return ans;
    }

    // DP
    // 因为第i天的状态只与第i-1天有关。所以dp数组可以降为2维数组
    // 又因为每一天只有6中状态，所以可以继续降维到一维数组(A:0,1 L:0,1,2)
    public int checkRecord3(int n) {
        // dp[i][j][k]: 第i+1天, 选了j次A, 连续选了K次L时的, 方案数
        int[][][] dp = new int[n][2][3];
        // 初始值
        // 第一天, 选了0次A, 0次L时，只有一种方案
        dp[0][0][0] = 1;
        // 第一天, 选了1次A, 0次L时，只有一种方案
        dp[0][1][0] = 1;
        // 第一天, 选了0次A, 1次L时，只有一种方案
        dp[0][0][1] = 1;

        // 从第二天开始计算
        for (int i = 1; i < n; i++) {
            // 本次选P, 则A可以为0或1, L肯定为0
            // 选了0次A, 0次L的情况，可以由前一天选了0次A, 0次L或前一天选了0次A, 1次L到达或前一天选了0次A, 2次L
            dp[i][0][0] = (((dp[i - 1][0][0] + dp[i - 1][0][1]) % MOD) + dp[i - 1][0][2]) % MOD;
            dp[i][1][0] = (((dp[i - 1][1][0] + dp[i - 1][1][1]) % MOD) + dp[i - 1][1][2]) % MOD;
            // 本次选A, 则A为1, L为0
            dp[i][1][0] = (((dp[i][1][0] + dp[i - 1][0][0]) % MOD) + ((dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD)) % MOD;
            // 本次选L, 则A为0或1, L为1或2
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        }
        int ans = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % MOD;
            }
        }
        return ans;
    }

}
