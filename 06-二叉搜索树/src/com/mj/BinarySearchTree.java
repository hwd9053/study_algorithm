package com.mj;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo{
	private int size;
	private Node<E> root;
	private Comparator<E> comparator; // 比较器
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public BinarySearchTree() {
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		// 添加第一个节点
		if(root == null) {
			root = new Node<E>(element, null);
			size++;
			return;
		}
		Node<E> node = root;
		Node<E> parent = null;
		int cmp = 0;
		while(node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if(cmp > 0) {
				node = node.right;
			} else if(cmp < 0) {
				node = node.left;
			} else { // 相等
				node.element = element;
				return;
			}
		}
		Node<E> newNode = new Node<>(element, parent);
		if(cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
	}
	
	public void remove(E element) {
		
	}
	
	public boolean contains(E element) {
		return false;
	}
	
//	/**
//	 * 前序遍历(根结点在前面)
//	 * 根节点，前序遍历左子树，前序遍历右子树
//	 * 以下是递归实现
//	 */
//	public void preorderTraversal() {
//		preorderTraversal(root);
//	}
//	
//	public void preorderTraversal(Node<E> node) {
//		if(node == null) return;
//		
//		System.out.print(node.element + ", ");
//		preorderTraversal(node.left);
//		preorderTraversal(node.right);
//	}
//	
//	/**
//	 * 中序遍历(根结点在中间)
//	 * 中序遍历左子树，根节点，中序遍历右子树
//	 * 以下是递归实现
//	 */
//	public void inorderTraversal() {
//		inorderTraversal(root);
//	}
//	
//	public void inorderTraversal(Node<E> node) {
//		if(node == null) return;
//		
//		inorderTraversal(node.left);
//		System.out.print(node.element + ", ");
//		inorderTraversal(node.right);
//	}
//	
//	/**
//	 * 后序遍历(根结点在最后)
//	 * 后序遍历左子树，后序遍历右子树，根节点
//	 * 以下是递归实现
//	 */
//	public void postorderTraversal() {
//		postorderTraversal(root);
//	}
//	
//	public void postorderTraversal(Node<E> node) {
//		if(node == null) return;
//		
//		postorderTraversal(node.left);
//		postorderTraversal(node.right);
//		System.out.print(node.element + ", ");
//	}
//	
//	/**
//	 * 层序遍历  要求能默写出来。前序等也要求，但因为是递归所以好写
//	 */
//	public void levelOrderTraversal() {
//		if(root == null) return;
//		
//		Queue<Node<E>> queue = new LinkedList<>();
//		queue.offer(root);
//		
//		while(!queue.isEmpty()) {
//			Node<E> node = queue.poll();
//			System.out.println(node.element);
//			if(node.left != null) queue.offer(node.left);
//			if(node.right != null) queue.offer(node.right);
//		}
//	}
	
	/**
	 * 前序遍历(根结点在前面)
	 * 根节点，前序遍历左子树，前序遍历右子树
	 * 以下是递归实现
	 */
	public void preorder(Visitor<E> visitor) {
		if (visitor == null) return;
		preorder(root, visitor);
	}
	
	public void preorder(Node<E> node, Visitor<E> visitor) {
		if (node == null) return;
		visitor.visit(node.element);
		preorder(node.left, visitor);
		preorder(node.right, visitor);
	}
	
	/**
	 * 中序遍历(根结点在中间)
	 * 中序遍历左子树，根节点，中序遍历右子树
	 * 以下是递归实现
	 */
	public void inorder(Visitor<E> visitor) {
		if (visitor == null) return;
		inorder(root, visitor);
	}
	
	public void inorder(Node<E> node, Visitor<E> visitor) {
		if (node == null) return;
		inorder(node.left, visitor);
		visitor.visit(node.element);
		inorder(node.right, visitor);
	}
	
	/**
	 * 后序遍历(根结点在最后)
	 * 后序遍历左子树，后序遍历右子树，根节点
	 * 以下是递归实现
	 */
	public void postorder(Visitor<E> visitor) {
		if (visitor == null) return;
		postorder(root, visitor);
	}
	
	public void postorder(Node<E> node, Visitor<E> visitor) {
		if (node == null) return;
		postorder(node.left, visitor);
		postorder(node.right, visitor);
		visitor.visit(node.element);
	}
	
	/**
	 * 层序遍历  要求能默写出来。前序等也要求，但因为是递归所以好写
	 */
	public void levelOrder(Visitor<E> visitor) {
		if(root == null || visitor == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			visitor.visit(node.element);
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
		}
	}
	
	// 树的高度,迭代实现(层序遍历)
	public int height() {
		if (root == null) return 0;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		// 树的高度
		int height = 0;
		// 存储着每一层的元素数量(根节点所在层有一个元素)
		int levelSize = 1;
		
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--; // 每次poll后，该层剩余元素减1
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if (levelSize == 0) { // levelSize == 0意味着即将访问下一层
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}
	
	// 树的高度
	public int height2() {
		return height(root);
	}
	
	// 节点的高度，递归实现
	private int height(Node<E> node) {
		if (node == null) return 0;
		
		return 1 + Math.max(height(node.left), height(node.left));
	}
	
	/**
	 * 通过visitor来让外界决定如何访问取到的元素
	 * @author Rin
	 *
	 * @param <E>
	 */
	public static interface Visitor<E> {
		void visit(E element);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(root, sb, "");
		return sb.toString();
	}
	
	// 利用前序遍历来打印
	private void toString(Node<E> node, StringBuilder sb, String prefix) {
		if(node == null) return;
		sb.append(prefix).append("【").append(node.element).append("】").append("\n");
		toString(node.left, sb, prefix + "【L】");
		toString(node.right, sb, prefix + "【R】");
		
	}
	
	private void elementNotNullCheck(E element) {
		if(element == null) {
			throw new IllegalArgumentException("element must not be null!");
		}
	}
	
	/**
	 * 
	 * @return 返回值等于0，代表e1和e2相等。大于0，代表e1大于e2。小于0，代表e1小于e2
	 */
	private int compare(E e1, E e2) {
		// 有比较器的话优先用比较器
		if(comparator != null) {
			return comparator.compare(e1, e2);
		}
		// 没有比较器的话，强转。如果强转失败，表示不可比较，而二叉搜索树的元素，必须可以比较。
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		@SuppressWarnings("unused")
		Node<E> parent;
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
	}

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		return ((Node<E>)node).element;
	}
}
