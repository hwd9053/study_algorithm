package 数学;

/**
 * https://leetcode-cn.com/problems/power-of-three/
 */
public class _326_3的幂 {
    // 常规做法
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }

        return true;
    }

    // 约数
    public boolean isPowerOfThree2(int n) {
        // 3^19 = 1162261467
        return n > 0 && 1162261467 % n == 0;
    }

}
