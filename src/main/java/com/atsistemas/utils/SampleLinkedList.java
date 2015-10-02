package com.atsistemas.utils;

/**
 * An implementation with algorithm a list doubly Linked 
 *
 */
public class SampleLinkedList<T>
{
	
	private Node<T> first = null;
	private Node<T> last = null;
	
	/*
	 * PUBLIC METHOD
	 */
	/**
	 * Add element in the last
	 * @param element
	 */
	public void add(T element) {
		if(isEmpty()){
			createFirstElement(element);
		}else{
			Node<T> node = new Node<T>(element, last, null);
			last.setAfter(node);
			last = node;
		}
	}
	/**
	 * Add element in position i
	 * 
	 * @param i
	 * @param string
	 */
	public void add(int position, T element) {
		
		if(0 == position){
			addFirst(element);
		}else{
			Node<T> elementi = getNode(position);
			
			Node<T> node = new Node<T>(element, elementi.getBefore(), elementi);
			elementi.getBefore().setAfter(node);
			elementi.setBefore(node);
		}
	}
	/**
	 * Add first element 
	 * @param element
	 */
	public void addFirst(T element) {
		Node<T> node = new Node<T>(element, null, first);
		first.setBefore(node);
		first = node;
	}
	/**
	 * Add in the last position
	 * @param element
	 */
	public void addLast(T element) {
		add(element);
	}
	
	/**
	 * Get the last element
	 * @return
	 */
	public T getLast() {
		if(isEmpty()){
			return null;
		}
		return last.getValue();
	}
	/**
	 * Get size list
	 * 
	 * @return
	 */
	public int size() {
		if(! isEmpty()){
			int i = 1;
			Node<T> posElement = first;
			while(posElement.getAfter() != null){
				posElement = posElement.getAfter();
				i++;
			}
			return i;
		}else{
			return 0;
		}
	}
	/**
	 * Get element by position
	 * @param position
	 * @return
	 */
	public T get(int position) {
		return getNode(position).getValue();
	}
	/**
	 * Delete the first element in list
	 */
	public void removeFirst() {
		if(!isEmpty()){
			if(first == last){
				first = null;
				last = null;
			}else{
				first.getAfter().setBefore(null);
				first = first.getAfter();
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	/**
	 * Delete last element in the list
	 */
	public void removeLast() {
		if(!isEmpty()){
			if(first == last){
				first = null;
				last = null;
			}else{
				last.getBefore().setAfter(null);
				last = last.getBefore();
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	/**
	 * Update the value in position
	 * @param position
	 * @param element
	 */
	public void set(int position, T element) {
		Node<T> node = getNode(position);
		node.setValue(element);
	}
	/**
	 * Remove the element in position
	 * @param i
	 */
	public void remove(int position) {
		Node<T> node = getNode(position);
		if(first.equals(node)){
			removeFirst();
		}else
			if(last.equals(node)){
				removeLast();
			}else{
				node.getBefore().setAfter(node.getAfter());
				node.getAfter().setBefore(node.getBefore());
				// node is free for gc
			}
	}
	/**
	 * Check is Empty the list
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if(first == null)
			return true;
		return false;
	}
	
	/**
	 *  Clear the list
	 */
	public void clear() {
		first = null;
		last = null;
		
		// NOTE Call GC with element.
		
	}
	/**
	 * Return the first position
	 * @param element
	 * @return
	 */
	public int indexOf(T element) {
		if(! isEmpty()){
			int i = 0;
			Node<T> posElement = first;
			while(posElement.getAfter() != null){
				if(posElement.getValue().equals(element)){
					return i;
				}
				posElement = posElement.getAfter();
				i++;
			}
			if(posElement.getValue().equals(element)){
				return i;
			}else{
				return -1;
			}
		}else{
			return -1;
		}
	}
	
	/**
	 * Generate iterator
	 * @return
	 */
	public SampleIteratorLinkedList<T> getIteratorLinkedList() {
		return new SampleIteratorLinkedList<T>(this);
	}
	
	/**
	 * PRIVATE METHOD
	 */
	
	
	/**
	 * Inicialized element
	 * @param element
	 */
	private void createFirstElement(T element){
		Node<T> node = new Node<T>(element, null, null);
		
		first = node;
		last = node;
	}
	/**
	 * Return node by position
	 * @param position
	 * @return
	 */
	private Node<T> getNode(int position) {
		if(! isEmpty()){
			if(position == 0){
				return first;
			}else{
				return findNode(position);
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	private Node<T> findNode(int position) {
		int ps = 0;
		
		Node<T> posElement = first;
		
		for(int i = 0; i<position+1; i++){
			if(position == ps){
				return posElement;
			}
			
			if(posElement.getAfter() == null){
				throw new IndexOutOfBoundsException();
			}
			posElement = posElement.getAfter();
			ps = i + 1;
		}
		if(position == ps){
			return posElement;
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	/**
	 * PROTECTED METHOD
	 */
	/**
	 * Get first node
	 * @return
	 */
	protected Node<T> getFirstNode(){
		return first;
	}
	/**
	 * Get last node
	 * @return
	 */
	protected Node<T> getLastNode(){
		return last;
	}
	/**
	 * Remove the current element.
	 */
	protected void remove(Node<T> t) {
		if(t.equals(first) && t.equals(last)){
			first = null;
			last = null;
		}else
			if(t.equals(first)){
				first = t.getAfter();
				first.setBefore(null);
			}else
				if(t.equals(last)){
					last = t.getBefore();
					last.setAfter(null);
				}else{
					t.getBefore().setAfter(t.getAfter());
					t.getAfter().setBefore(t.getBefore());
				}
	}
	/**
	 * Add before
	 */
	protected void addBefore(Node<T> current, T element) {
		if(current.equals(first)){
			addFirst(element);
		}else{
			Node<T> node = new Node<T>(element, current.getBefore(), current);
			current.getBefore().setAfter(node);
			current.setBefore(node);
		}
	}
	/**
	 * Add After
	 */
	protected void addAfter(Node<T> current, T element) {
		if(current.equals(last)){
			addLast(element);
		}else{
			Node<T> node = new Node<T>(element, current, current.getAfter());
			current.getAfter().setBefore(node);
			current.setAfter(node);
		}
	}
}
