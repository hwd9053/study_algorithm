package DFS;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 * https://leetcode-cn.com/problems/path-sum-iii/solution/lu-jing-zong-he-iii-by-leetcode-solution-z9td/
 */
public class _437_路径总和_III {
    // DFS
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ret = dfs(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);

        return ret;
    }

    // 表示以节点root为起点向下且路径和为targetSum的路劲总和
    private int dfs(TreeNode root, int targetSum) {
        if (root == null) return 0;
        targetSum -= root.val;

        int left = dfs(root.left, targetSum);
        int right = dfs(root.right, targetSum);

        int ans = targetSum == 0 ? 1 : 0;

        return ans + left + right;
    }



    // 通过前缀和优化
    // https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 这句代码要是不理解, 就去看560题
        map.put(0, 1);

        int ans = dfs2(root, map, targetSum, 0);

        return ans;
    }

    private int dfs2(TreeNode root, Map<Integer, Integer> map, int targetSum, int curSum) {
        if (root == null) return 0;
        curSum += root.val;
        int ans = 0;

        if (map.containsKey(curSum - targetSum)) {
            ans += map.get(curSum - targetSum);
        }
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        ans += dfs2(root.left, map, targetSum, curSum);
        ans += dfs2(root.right, map, targetSum, curSum);

        // 回溯, 否则会影响该路径上前面的节点往右走的结果
        map.put(curSum, map.get(curSum) - 1);

        return ans;
    }
}
