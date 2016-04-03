package com.example.getmin;

import java.util.Stack;

/**
 *	第一种方案
 *  压入数据规则：
 *  	（１）假设当前数据为newNum, 先将其压入stackData。然后判断stackMin是否为空；
 *  	（２）如果为空，则newNum也压入stackMin；
 *  	（３）如果不为空，则比较newNum和stackMin的栈顶元素中哪一个更小；
 *  	（４）如果newNum更小或者两者相等，则newNum也压入stackMin;
 *  	（５）如果stackMin中的栈顶元素小，则stackMin不压入任何内容；
 *  弹出数据规则：
 *  	（１）先在stackData中弹出栈顶元素，记为value。然后比较当前stackMin的栈顶元素和value的哪一个更小；
 *  	（２）当value等于stackMin的栈顶元素时，stackMin弹出栈顶元素；当value大于stackMin的栈顶元素时，stackMin不弹出栈顶元素；返回value;
 *  
 *   查询当前栈中的最小值：
 *   	stackMin的栈顶元素始终是当前stackData中的最小值
 */
public class MyStack1 implements StackOperation<Float> {
	private Stack<Float> stackData;
	private Stack<Float> stackMin;
	
	public MyStack1() {
		stackData = new Stack<>();
		stackMin = new Stack<>();
	}
	
	@Override
	public Float pop() {
		if(stackData.isEmpty()) {
			return null;
		}
		Float value = stackData.pop();
		if(value == stackMin.peek()) {
			stackMin.pop();
		}
		
		return value;
		
	}
	
	@Override
	public void push(Float num) {
		stackData.push(num);
		if(stackMin.isEmpty()) {
			stackMin.push(num);
		} else {
			if(num <= stackMin.peek()) {
				stackMin.push(num);
			}
		}
	}
	
	@Override
	public Float getMin() {
		if(stackMin.isEmpty()) {
			return null;
		}
		return stackMin.peek();
	}

}
