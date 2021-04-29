package 数学;

/**
 * https://leetcode-cn.com/problems/sign-of-the-product-of-an-array/
 */
public class _1822_数组元素积的符号 {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            ans *= num > 0 ? 1 : -1;
        }
        return ans;
    }
}
