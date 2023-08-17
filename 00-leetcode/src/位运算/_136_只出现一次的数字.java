package 位运算;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/single-number/
 */
public class _136_只出现一次的数字 {
    // 利用set或者map或者集合。时间空间均O(n)
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        for (Integer integer : set) {
            ans = integer;
            break;
        }

        return ans;
    }

    // 利用异或运算
    // 由于题目明确只有一个数字不重复，其他数字均成对出现
    // 而两个相同数字异或结果为0
    // 0与任一数字异或结果仍为该数字
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
