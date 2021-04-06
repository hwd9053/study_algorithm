package 刷题用包;

/**
 * https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/
 */
public class _1448_统计二叉树中好节点的数目 {
    int ans = 0;
    public int goodNodes(TreeNode root) {
        goodNodes(root, root.val);
        return ans;
    }

    private void goodNodes(TreeNode node, int parentsMax) {
        if (node == null) return;
        if (node.val >= parentsMax) {
            ans++;
            parentsMax = node.val;
        }
        goodNodes(node.left, parentsMax);
        goodNodes(node.right, parentsMax);
    }
}
