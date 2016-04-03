package com.example.getmin;

public interface StackOperation<T> {
	public T pop();
	public void push(T num);
	public T getMin();
}
