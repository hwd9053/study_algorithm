package 二叉树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/delete-nodes-and-return-forest/description/
 */
public class _1110_删点成林 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int delete : to_delete) {
            set.add(delete);
        }
        TreeNode node = dfs(root, set, res);
        if (node != null) {
            res.add(node);
        }
        return res;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> res) {
        if (root == null) return null;

        TreeNode left = dfs(root.left, set, res);
        TreeNode right = dfs(root.right, set, res);

        if (set.contains(root.val)) {
            if (left != null) {
                res.add(left);
            }
            if (right != null) {
                res.add(right);
            }
            return null;
        } else {
            root.left = left;
            root.right = right;
        }
        return root;
    }

}
