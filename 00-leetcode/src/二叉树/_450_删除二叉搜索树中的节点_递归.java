package 二叉树;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 通过递归解决
 * @author Rin
 *
 */
public class _450_删除二叉搜索树中的节点_递归 {
	
    public TreeNode deleteNode(TreeNode root, int key) {
    	if (root == null) return null;
    	
    	if (root.val > key) {
    		root.left = deleteNode(root.left, key);
    	} else if (root.val < key) {
    		root.right = deleteNode(root.right, key);
    	} else { // 相等，找到了要删除的节点
//    		if (root.left == null) {
//    			return root.right;
//    		} else if (root.right == null) {
//    			return root.left;
//    		} else {
//    			...
//    		}
    		
    		if (root.left == null && root.right == null) {
    			return null;
    		} else if (root.left != null && root.right == null) {
    			return root.left;
    		} else if (root.left == null && root.left != null) {
    			return root.right;
    		} else { // 度为2
    			TreeNode node = root.right;
    			TreeNode pre = root;
    			while(node.left != null) {
    				pre = node;
    				node = node.left;
    			}
    			root.val = node.val;
    			if (pre.left == node) {
    				pre.left = node.left == null ? node.right : node.left; 
    			} else {
    				pre.right = node.left == null ? node.right : node.left;
    			}
    			return root;
    		}
    	}
    	return root;
    }
}
