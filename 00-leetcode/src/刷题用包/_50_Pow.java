package 刷题用包;

public class _50_Pow {
    // 递归
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double half = myPow(x, n >> 1);
        half *= half;
        boolean odd = (n & 1) == 1;
        return odd ? half * x : half;
    }

    // 迭代
    public double myPow2(double x, int n) {
        double res = 1;
        long y = n < 0 ? - ((long) n) : n;
        while (y != 0) {
            if ((y & 1) == 1) {
                res *= x;
            }
            x *= x;
            y >>= 1;
        }

        return n < 0 ? 1 / res : res;
    }

}
