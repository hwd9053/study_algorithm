package 数组;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/random-pick-with-weight/
 */
public class _528_按权重随机选择 {
    // 前缀和 + 二分
    class Solution {

        int[] pre;
        int total;

        // 构建前缀和数组，并计算出w中所有元素的和
        public Solution(int[] w) {
            pre = new int[w.length];
            pre[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                pre[i] = pre[i - 1] + w[i];
            }
            total = pre[pre.length - 1];
        }

        public int pickIndex() {
            // 生成0~total之间的随机整数
            int ran = (int)(Math.random() * total) + 1;
            // 返回这个随机数落在的区间
            return binarySearch(ran);
        }

        // 通过二分法查找第一个大于等于target的pre[i]的i
        private int binarySearch(int target) {
            int l = 0, r = pre.length - 1;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (pre[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

}
