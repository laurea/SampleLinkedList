/**
 * 
 */
package com.atsistemas.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation Iterator and new method for a list doubly Linked.
 * 
 * @author laurea
 * @param <E>
 *
 */
public class SampleIteratorLinkedList<E> implements Iterator<E> {
	
	SampleLinkedList<E> list;
	Node <E> position; 
	
	public SampleIteratorLinkedList(SampleLinkedList<E> linkedList){
		this.list = linkedList;
		position = list.getFirstNode();
	}
	
	/**
	 * Check has next element
	 */	
	public boolean hasNext() {
		return position != null; 
	}

	/**
	 * check has previus element
	 * @return
	 */
	public boolean hasPrevius() {
		return position != null;
	}
	/**
	 * Return next element
	 */
	public E next() {
		if(!hasNext()){
		      throw new NoSuchElementException();
		}
		E value = position.getValue();
		position = position.getAfter();
		return value;
	}
	/**
	 * Return previus element
	 */
	public E previus() {
		if(!hasPrevius()){
		      throw new NoSuchElementException();
		}
		E value = position.getValue();
		position = position.getBefore();
		return value;
	}
	/**
	 * Set the position first, default
	 */
	public void toStart(){
		position = list.getFirstNode();
	}
	/**
	 * Set the last position.
	 */
	public void toEnd(){
		position = list.getLastNode();
	}

	/**
	 * Remove the current element.
	 */
	public void remove() {
		list.remove(position);	
	}
	/**
	 * Add before
	 */
	public void addBefore(E element) {
		list.addBefore(position, element);	
	}
	/**
	 * Add After
	 */
	public void addAfter(E element) {
		list.addAfter(position, element);	
	}
}
