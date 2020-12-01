package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author Rin
 *
 */
public class _105_从前序与中序遍历序列构造二叉树 {
	
	public TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight,
		int inLeft, int inRight, Map<Integer, Integer> map) {
		if (preLeft > preRight) return null;
		int rootVal = preorder[preLeft];
		int rootIndex = map.get(rootVal);
		
		TreeNode node = new TreeNode(rootVal);
		
		int leftLen = rootIndex - inLeft;
		//int rightLen = inRight - rootIndex;
		
		node.left = buildTree(preorder, inorder, preLeft + 1, preLeft + leftLen, 
				inLeft, rootIndex - 1, map);
		node.right = buildTree(preorder, inorder, preLeft + leftLen + 1, preRight, 
				rootIndex + 1, inRight, map);
		
		return node;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) return null;
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < inorder.length; i++) {
    		map.put(inorder[i], i);
    	}
    	
    	TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    	
    	return root;
    }
}
