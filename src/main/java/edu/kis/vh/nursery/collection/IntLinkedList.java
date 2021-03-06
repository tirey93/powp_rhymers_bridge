package edu.kis.vh.nursery.collection;

import edu.kis.vh.nursery.IntStack;

public class IntLinkedList implements IntStack{

	private static final int VALIDVALUE = 0;
	private Node last;

	public void push(int i) {
		if (last == null)
			last = new Node(i);
		else {
			last.setNext(new Node(i));
			last.getNext().setPrev(last);
			last = last.getNext();
		}
	}
	
	public int numberOfElements() {
		int res = 0;
		Node lastLocal = last;
		while(lastLocal.getPrev() != null) {
			res++;
		}
		return res;
	}
	public boolean isEmpty() {
		return last == null;
	}

	public boolean isFull() {
		return false;
	}

	public int top() {
		if (isEmpty())
			return VALIDVALUE;
		return last.getValue();
	}

	public int pop() {
		if (isEmpty())
			return VALIDVALUE;
		int ret = last.getValue();
		last = last.getPrev();
		return ret;
	}

	 @Override
	    public int peek() {
	        if (isEmpty()) {
	            return VALIDVALUE;
	        }
	        return last.getValue();
	    }

}
 class Node {

	private final int value;
	private Node prev;
	private Node next;

	public Node(int i) {
		value = i;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public int getValue() {
		return value;
	}

	
}

