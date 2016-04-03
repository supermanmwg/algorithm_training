package com.example.getmin;
/**
 *　题目： 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 *　要求：(1) pop, push, getMin操作的时间复杂度都是O(l)
 *		(2) 设计的栈类型可以使用现成的栈结构
 *　设计：
 *	　　我们使用两个栈，一个栈用来保存当前栈中的元素，其功能和一个正常的栈没有区别，这个栈记为stackData;
 *	   另一个栈用于保存每一步的最小值，这个栈记为stackMin;
 *  实现: 有两种实现方法。	   
 */


public class GetMin {

	public static void main(String[] args) {
		System.out.println("MyStack 1 test is begin");
		MyStack1 stack1 = new MyStack1();
		stack1.push(9.0f);
		stack1.push(8.0f);
		stack1.push(10.0f);
		stack1.push(7.0f);
		stack1.push(12.0f);
		
		while(stack1.getMin()!= null) {
			System.out.println("min data is " + stack1.getMin() + "top data is " + stack1.pop());
		}
		System.out.println("MyStack 1 test is end");
		
		System.out.println("========================");
		System.out.println("MyStack 2 test is begin");
		MyStack2 stack2 = new MyStack2();
		stack2.push(9.0f);
		stack2.push(8.0f);
		stack2.push(10.0f);
		stack2.push(7.0f);
		stack2.push(12.0f);
		
		while(stack2.getMin()!= null) {
			System.out.println("min data is " + stack2.getMin() + "top data is " + stack2.pop());
		}
		System.out.println("MyStack 2 test is end");

	}


}
