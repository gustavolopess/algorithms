package ch02;

public class CustomLinkedList<T> {
	protected class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(T d) {
			this.data = d;
			next = null;
			prev = null;
		}
		public Node() {
			next = null;
			prev = null;
		}
		
		public T getData() {
			return data;
		}
		
		public Node<T> getNext() throws NullPointerException {
			if (next == null) throw new NullPointerException("Null next pointer");
			return next;
		}
		
		public void setNext(Node<T> n) {
			next = n;
		}
		
		public void setPrev(Node<T> n) {
			prev = n;
		}
		
		public Node<T> getPrev() throws NullPointerException {
			if (prev == null) throw new NullPointerException("Null prev pointer");
			return prev;
		}
	}
	
	Node<T> head;
	Node<T> tail;
	long size;
	
	
	public CustomLinkedList() {
		head = new Node<T>();
		tail = new Node<T>();
		head.setNext(tail);
		tail.setPrev(head);
		size = 0;
	}
	
	
	public long getSize() {
		return size;
	}
	
	public void pushBack(T d) {
		Node<T> before = tail.getPrev();
		Node<T> newNode = new Node<T>(d);
		before.setNext(newNode);;
		newNode.setNext(tail);
		newNode.setPrev(before);
		tail.setPrev(newNode);
		size++;
	}
	
	public void pushFront(T d) {
		Node<T> after = head.getNext();
		Node<T> newNode = new Node<T>(d);
		after.setPrev(newNode);
		newNode.setNext(after);
		newNode.setPrev(head);
		head.setNext(newNode);
		size++;
	}
	
	public Node<T> popBack() throws IllegalStateException {
		if (isEmpty()) throw new IllegalStateException("Cannot pop from an empty list");
		Node<T> popped = tail.getPrev();
		tail.setPrev(popped.getPrev());
		popped.getPrev().setNext(tail);
		size--;
		return popped;
	}
	
	public Node<T> popFront() throws IllegalStateException {
		if (isEmpty()) throw new IllegalStateException("Cannot pop from an empty list");
		Node<T> popped = head.getNext();
		head.setNext(popped.getNext());
		popped.getPrev().setPrev(head);
		size--;
		return popped;
	}
	
	public void pushAllBack(T[] all) {
		for (T elt : all) {
			pushBack(elt);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> curr = head.getNext();
		while (curr != tail) {
			sb.append(curr.getData() + " ");
			curr = curr.getNext();
		}
		return sb.toString();
	}
	
	public Boolean isEmpty() {
		return size == 0;
	}
	
	
	public static void main(String[] args) {
		CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
		list.pushBack(10);
		list.pushBack(20);
		list.pushFront(300);
		System.out.println(list);
		list.popBack();
		System.out.println(list.getSize());
		list.popBack();
		System.out.println(list);
		list.popBack();
		list.popBack();
	}
}
