package com.mj;

import java.util.Comparator;

import com.mj.printer.BinaryTrees;

public class Main {
	
	public static void main(String[] args) {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12 , 1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		for(int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		bst.preorderTraversal();
		System.out.println();
		bst.inorderTraversal();
		System.out.println();
		bst.postorderTraversal();
		System.out.println();
		bst.levelOrderTraversal();
		
		
		// 利用匿名类创建比较器
		@SuppressWarnings("unused")
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}
		});
	}

}
