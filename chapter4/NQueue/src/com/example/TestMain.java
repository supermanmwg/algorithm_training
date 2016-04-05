package com.example;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("1 queue is " + num1(1));
		System.out.println("2 queue is " + num1(2));
		System.out.println("3 queue is " + num1(3));
		System.out.println("4 queue is " + num1(4));
		long time1 = System.currentTimeMillis();
		System.out.println("15 queue is " + num1(15));
		long time2 = System.currentTimeMillis();
		System.out.println("time is " + (time2 - time1) / 1000);
	}
	
	public static int num1(int n) {
		if(n < 1) {
			return 0;
		}
		int[] record = new int[n];
		return process1(0, record, n);
	}
	
	public static int process1(int i, int[] record, int n) {
		if(i == n) {
			return 1;
		}
		int res = 0; 
		for(int j = 0; j < n; j++) {
			if(isValid(record, i, j)) {
				record[i] = j;
				res += process1(i+1, record, n);
			}
		}
		
		return res;
	}
	
	public static boolean isValid(int[] record, int i, int j) {
		for(int k = 0; k < i; k++) {
			if(j == record[k] || Math.abs(j - record[k]) == Math.abs(i - k)) {
				return false;
			}
		}
		
		return true;
	}

}
