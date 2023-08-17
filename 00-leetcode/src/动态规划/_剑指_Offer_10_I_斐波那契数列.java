package 动态规划;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class _剑指_Offer_10_I_斐波那契数列 {
    int mod = 1000000007;

    // 暴力递归
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // 记忆化搜索
    public int fib1(int n) {
        if (n == 0 || n == 1) return n;
        int[] memo = new int[n];
        return (fib1(n - 1, memo) + fib1(n - 2, memo)) % mod;
    }

    private int fib1(int n, int[] memo) {
        if (n == 0 || n == 1) return n;
        if (memo[n] == 0) {
            memo[n] = (fib1(n - 1, memo) + fib1(n - 2, memo)) % mod;
        }

        return memo[n];
    }

    // 动态规划(可优化空间)
    public int fib2(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        return dp[n - 1];
    }


}
