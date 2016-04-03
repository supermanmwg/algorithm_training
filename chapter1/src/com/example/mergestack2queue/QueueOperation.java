package com.example.mergestack2queue;

public interface  QueueOperation<T> {
	public void add(T t);
	public  T pop();
	public T peek();
}
