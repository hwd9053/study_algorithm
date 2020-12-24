package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {

    List<Integer> list = new ArrayList<>();

    // 后序遍历的递归解
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);

        return list;
    }

//    // 后序遍历的迭代解
//    // 用栈模拟后续遍历的顺序
//    public List<Integer> postorderTraversal2(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) return list;
//        Stack<TreeNode> stack = new Stack<>();
//
//        while (root != null) {
//            list.add(root.val);
//            if (root.right != null) {
//                stack.push(root.right);
//            }
//            if (root.left != null) {
//                root = root.left;
//            } else if (!stack.isEmpty()){
//                root = stack.pop();
//            } else {
//                root = null;
//            }
//        }
//        return list;
//    }
}
