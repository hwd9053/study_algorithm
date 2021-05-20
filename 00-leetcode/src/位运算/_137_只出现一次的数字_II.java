package 位运算;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
 */
public class _137_只出现一次的数字_II {
    // 位运算，需要掌握
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    counts[i]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 3 == 1) {
                ans += (1 << i);
            }
        }

        return ans;
    }

    // TODO 状态机，有空的时候最好学一下..

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3};
        _137_只出现一次的数字_II test = new _137_只出现一次的数字_II();
        System.out.println(test.singleNumber(nums));
    }
}
