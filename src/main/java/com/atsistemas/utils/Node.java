package com.atsistemas.utils;

/**
 * Node doubly linked list
 * 
 * @author laurea
 *
 * @param <T>
 */
public class Node<T>{
	private Node<T> before;
	private Node<T> after; 
	private T value;
	
	public Node(T value, Node<T> before, Node<T> after){
		this.value = value;
		this.before = before;
		this.after = after;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getBefore() {
		return before;
	}

	public void setBefore(Node<T> before) {
		this.before = before;
	}

	public Node<T> getAfter() {
		return after;
	}

	public void setAfter(Node<T> after) {
		this.after = after;
	}
}
