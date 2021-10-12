package 位运算;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
 * 二进制是如何表示数字的。。。
 */
public class _29_两数相除 {
    /**
     * 解题思路：这题是除法，所以先普及下除法术语
     * 商，公式是：(被除数-余数)÷除数=商，记作：被除数÷除数=商...余数，是一种数学术语。
     * 在一个除法算式里，被除数、余数、除数和商的关系为：(被除数-余数)÷除数=商，记作：被除数÷除数=商...余数，
     * 进而推导得出：商×除数+余数=被除数。
     *
     * 要求商，我们首先想到的是减法，能被减多少次，那么商就为多少，但是明显减法的效率太低
     *
     * 那么我们可以用位移法，因为计算机在做位移时效率特别高，向左移1相当于乘以2，向右位移1相当于除以2
     *
     * 我们可以把一个dividend（被除数）先除以2^n，n最初为31，不断减小n去试探,当某个n满足dividend/2^n>=divisor时，
     *
     * 表示我们找到了一个足够大的数，这个数*divisor是不大于dividend的，所以我们就可以减去2^n个divisor，以此类推
     *
     * 我们可以以100/3为例
     *
     * 2^n是1，2，4，8...2^31这种数，当n为31时，这个数特别大，100/2^n是一个很小的数，肯定是小于3的，所以循环下来，
     *
     * 当n=5时，100/32=3, 刚好是大于等于3的，这时我们将100-32*3=4，也就是减去了32个3，接下来我们再处理4，同样手法可以再减去一个3
     *
     * 所以一共是减去了33个3，所以商就是33
     *
     * 这其中得处理一些特殊的数，比如divisor是不能为0的，Integer.MIN_VALUE和Integer.MAX_VALUE
     *
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean negative = (dividend ^ divisor) < 0; // 通过异或来判断符号是否相同
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        int ans = 0;

        // 求被除数中有多少个除数
        // 通过二进制表示个数
        // 例如 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
        for (int i = 31; i >= 0; i--) {
            if ((dividendL >> i) >= divisorL) { // 被除数中是否包含2 ^ i个除数
                ans += 1 << i; // 包含的话，加上2 ^ i
                dividendL -= divisorL << i; // 从被除数中减去 除数 * (2 ^ i)
            }
        }

        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(60 >> 2);
        System.out.println(new _29_两数相除());
    }
}
