package com.example.mergestack2queue;

import java.util.Stack;

/**
 * 
 *　编写一个类，用两个栈实现队列，支持队列的基本操作　（add, poll, peek）;
 *
 *	实现：
 *		一个栈作为压入栈，在压入数据时只往这个栈中压入，记为stackPush; 
 *		另一个栈只作为弹出栈，在弹出数据时，只从这个栈弹出；
 *	注意：
 *		（１）如果stackPush要往StackPop中压入数据，那么必须一次性把stackPush中的数据全部压入；
 *		（２）如果stackPop不为空，stackPush绝对不能向stackPop中压入数据；
 */

public class MergeStack2queue implements QueueOperation<Float>{
	private Stack<Float> stackPush;
	private Stack<Float> stackPop;
	
 	public MergeStack2queue() {
		stackPop = new Stack<>();
		stackPush = new Stack<>();
	}
 	
	@Override
	public void add(Float t) {
		stackPush.push(t);
	}

	@Override
	public Float pop() {
		if(stackPop.isEmpty() && stackPush.isEmpty())  {
			return null;
		} else {
			if(stackPop.isEmpty()) {
				while(!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
		}
		
		return stackPop.pop();
	}

	@Override
	public Float peek() {
		if(stackPop.isEmpty() && stackPush.isEmpty()) {
			return null;
		} else if (stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		
		return stackPop.peek();
	}

}
