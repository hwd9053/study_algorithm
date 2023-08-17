package 数学;

/**
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class _1137_第N个泰波那契数 {
    // 也可以看作DP，但是优化了空间复杂度
    public int tribonacci(int n) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;

        int val1 = 0, val2 = 1, val3 = 1;
        int temp = 0, ans = 0;

        for (int i = 3; i <= n; i++) {
            temp = i % 3;
            ans = val1 + val2 + val3;
            if (temp == 0) {
                val1 = ans;
            } else if (temp == 1) {
                val2 = ans;
            } else {
                val3 = ans;
            }
        }
        return ans;

        // 官方的这个写法很棒。值得学习
/*        int p = 0, q = 0, r = 1, s = 1;
        for (int i = 3; i <= n; ++i) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;*/
    }

    // DP
    public int tribonacci2(int n) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;
        // ans[i]: 表示第i个泰波那契数
        int[] ans = new int[n + 1];
        // 初始值
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 1;

        for (int i = 3; i < ans.length; i++) {
            ans[i] = ans[i - 3] + ans[i - 2] + ans[i - 1];
        }

        return ans[n - 1];
    }

    public static void main(String[] args) {
        new _1137_第N个泰波那契数().tribonacci(8);
    }
}
