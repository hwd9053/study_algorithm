package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @author linkage
 *
 */
public class _剑指Offer31_栈的压入_弹出序列 {
	// 模拟入栈出栈
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	Stack<Integer> stack = new Stack<>();
    	int index = 0;
    	for(int i : pushed) {
    		stack.push(i);
    		if (i == popped[index]) {
    			stack.pop();
    			if (stack.peek())
    		}
    	}
    }
}
