package com.example.reverse;

import java.util.Stack;

/**
 * 
 * 题目　实现栈中元素逆序，但是只能用递归函数实现 
 *
 */

public class ReveseStack {
	public static <T> T getAndRemoveLastElement(Stack<T> stack) {
		T result = stack.pop();
		
		if(stack.isEmpty()) {
			return result;
		} else {
			T last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}		
	}
	
	public static <T> void reverse(Stack<T> stack) {
		if(stack.isEmpty()) {
			return;
		} else {
			T i = getAndRemoveLastElement(stack);
			reverse(stack);
			stack.push(i);
		}
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.add(4);
		stack.add(5);
		stack.add(6);
		
		reverse(stack);
		output(stack);
	}
	
	public static void output(Stack stack) {
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
