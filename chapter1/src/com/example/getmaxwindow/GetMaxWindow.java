package com.example.getmaxwindow;

import java.util.LinkedList;

import com.sun.javafx.image.IntPixelAccessor;

public class GetMaxWindow {
	public static int[] getMaxWindow(int[] arr, int w) {
		if(null == arr || w < 1 || arr.length < w) {
			return null;
		}
		
		LinkedList<Integer> qmax = new LinkedList<>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst() == i -w){
				qmax.pollFirst();
			}
			
			if(i >= w-1) {
				res[index++] = arr[qmax.peekFirst()];
		
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] array = {4, 3, 5, 4, 3, 3, 6, 7};
		int[] reses = getMaxWindow(array, 3);
		
		for(int i : reses) {
			System.out.println(i);
		}
	}
}
