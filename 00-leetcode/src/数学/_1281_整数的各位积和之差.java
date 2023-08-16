package 数学;

/**
 * https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class _1281_整数的各位积和之差 {
    public int subtractProductAndSum(int n) {
        int num;
        int sum = 0, multi = 1;
        while (n > 0) {
            num = n % 10;
            sum += num;
            multi *= num;
            n /= 10;
        }

        return multi - sum;
    }
}
