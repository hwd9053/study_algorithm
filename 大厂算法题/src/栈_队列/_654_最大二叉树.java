package 栈_队列;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findRoot(nums, 0, nums.length);
    }

    // 找出[l, r)范围内的根节点
    private TreeNode findRoot(int[] nums, int l, int r) {
        if (l == r) return null;

        // 找出[l, r)范围内的最大索引
        int maxIdx = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = findRoot(nums, l, maxIdx);
        root.right = findRoot(nums, maxIdx + 1, r);
        return root;
    }

    // 要求返回一个数组，里面存放着原数组元素对应的父节点的索引
    public int[] parentIndexes(int[] nums) {

        return null;
    }
}
