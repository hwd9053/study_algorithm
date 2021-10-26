package 数组;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class _496_下一个更大元素_I {
    // 笨办法。时间O(mn)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        // key: 值, value: 索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int idx = map.get(nums1[i]);
            for (int j = idx + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
            if (ans[i] == 0) ans[i] = -1;
        }

        return ans;
    }

    // 单调栈 时间O(m+n)
    // 如何更高效地计算 nums2中每个元素右边的第一个更大的值；
    // 如何存储第 11 个子问题的结果。
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        // key: 当前值, value: 右边第一个比当前值大的值
        Map<Integer, Integer> map = new HashMap<>();
        // 利用单调栈来快速找到右边第一个比自己大的数
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums2[0]);

        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
