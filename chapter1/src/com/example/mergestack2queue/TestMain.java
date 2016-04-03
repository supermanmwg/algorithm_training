package com.example.mergestack2queue;

public class TestMain {
	public static void main(String[] args) {
		MergeStack2queue merge = new MergeStack2queue();
		
		merge.add(4.0f);
		merge.add(5.0f);
		merge.add(6.0f);
		merge.add(7.0f);
		
		System.out.println("merge peek item is " + merge.pop());
		System.out.println("merge peek item is " + merge.pop());
		System.out.println("merge peek item is " + merge.pop());
		
		merge.add(8.0f);
		merge.add(9.0f);
		merge.add(10.0f);
		
		System.out.println("merge peek item is " + merge.pop());
		System.out.println("merge peek item is " + merge.pop());
		System.out.println("merge peek item is " + merge.pop());
		System.out.println("merge peek item is " + merge.pop());
		
	}
}
