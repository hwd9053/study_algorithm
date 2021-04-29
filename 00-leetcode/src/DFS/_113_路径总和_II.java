package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class _113_路径总和_II {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, 0, ans, path);

        return ans;
    }

    private void dfs(TreeNode root, int targetSum, int sum, List<List<Integer>> ans, List<Integer> path) {
        path.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                ans.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum, sum, ans, path);
        }

        if (root.right != null) {
            dfs(root.right, targetSum, sum, ans, path);
        }
        path.remove(path.size() - 1);
    }


    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> path = new ArrayList<>();

        dfs2(root, targetSum, 0, ans, path);

        return ans;
    }

    private void dfs2(TreeNode root, int targetSum, int sum, List<List<Integer>> ans, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            ans.add(new ArrayList<>(path));
            return;
        }

        dfs2(root.left, targetSum, sum, ans, path);
        dfs2(root.right, targetSum, sum, ans, path);

        path.remove(path.size() - 1);
    }
}
