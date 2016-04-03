package com.example.getmin;

import java.util.Stack;

/**
 *	压入数据规则：
 *	（１）假设当前数据为newNum,先将其压入stackData。然后判断stackMin是否为空。
 *	（２）如果为空，则newNum也压入stackMin;如果不为空，则比较newNum和stackMin的栈顶元素哪一个更小；
 *	（３）如果newNum更小或者两者相等，则newNum也压入stackMin;如果stackMin中栈顶元素小，则把stackMin的栈顶元素重复压入stackMin.
 *
 *	弹出数据规则：
 *		在stackData中弹出数据，弹出的数据记为value;弹出stackMin中的栈顶；返回value;
 *
 *	查询当前栈中的最小值：
 *   	stackMin的栈顶元素始终是当前stackData中的最小值
 */
public class MyStack2 implements StackOperation<Float>{
	private Stack<Float> stackData;
	private Stack<Float> stackMin;
	
	public MyStack2() {
		stackData = new Stack<>();
		stackMin = new Stack<>();
	}

	@Override
	public Float pop() {
		if(stackData.isEmpty()) {
			return null;
		}
		
		Float value = stackData.pop();
		stackMin.pop();
		
		return value;
	}

	@Override
	public void push(Float num) {
		stackData.push(num);
		if(stackMin.isEmpty()) {
			stackMin.push(num);   	//这一句别忘了
		} else if(num <= stackMin.peek()) {
			stackMin.push(num);
		} else {
			stackMin.push(stackMin.peek());
		}
	}

	@Override
	public Float getMin() {
		if(stackMin.isEmpty()) {
		return null;
		} else {
			return stackMin.peek();
		}
	}

}
