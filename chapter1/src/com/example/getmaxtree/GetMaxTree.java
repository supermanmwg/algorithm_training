package com.example.getmaxtree;

import java.util.HashMap;
import java.util.Stack;

public class GetMaxTree {

	public static void main(String[] args) {
		int[] array = {3, 4, 5, 1, 2};
		Node head = getMaxTree(array);
		System.out.println("hehe");
	}
	
	public static Node getMaxTree(int[] arr) {
		Node[] nArr =new Node[arr.length];
		for(int i = 0; i < arr.length; i++) {
			nArr[i] = new Node(arr[i]);
		}
		
		Stack<Node> stack = new Stack<>();
		HashMap<Node, Node> lBigMap = new HashMap<>();
		HashMap<Node, Node> rBigMap = new HashMap<>();
		
		for (int i = 0; i != nArr.length; i++) {
			Node curNode = nArr[i];
			while(!stack.isEmpty() && stack.peek().value < curNode.value) {
				popStackSetMap(stack, lBigMap);
			}
			stack.push(curNode);
		}
		
		while(!stack.isEmpty()) {
			popStackSetMap(stack, lBigMap);
		}
		
		for(int i = nArr.length - 1; i != -1; i--) {
			Node curNode = nArr[i];
			while(!stack.isEmpty() && stack.peek().value < curNode.value) {
				popStackSetMap(stack, rBigMap);
			}
			
			stack.push(curNode);
		}
		
		while(!stack.isEmpty()) {
			popStackSetMap(stack, rBigMap);
		}
		
		Node head = null;
		
		for (int i = 0; i != nArr.length; i++) {
			Node curNode = nArr[i];
			Node left = lBigMap.get(curNode);
			Node right = rBigMap.get(curNode);
			
			if(null == left && null == right) {
				head = curNode;
			} else if(null == left) {
				if(right.left == null) {
					right.left = curNode;
				} else {
					right.right = curNode;
				}
			} else if(null == right) {
				if(left.left == null) {
					left.left = curNode;
				} else {
					left.right = curNode;
				}
			} else {
				Node parent = left.value < right.value ? left : right;
				
				if(parent.left == null) {
					parent.left = curNode;
				} else {
					parent.right = curNode;
				}
			}
		}
		
		return head;
	}
	
	public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
		Node popNode = stack.pop();
		
		if(stack.isEmpty()) {
			map.put(popNode, null);
		} else {
			map.put(popNode, stack.peek());
		}
	}
}
