package 二分;

/**
 * https://leetcode.cn/problems/sqrtx/
 */
public class _69_x的平方根 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0, r = x / 2;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            long product = (long) mid * mid;
            if (product == x) {
                return mid;
            } else if (product > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(new _69_x的平方根().mySqrt(8));
    }
}
