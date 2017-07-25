package ch02;

public class CustomLinkedList<T> {
	private static class Node<T> {
		private T data;
		private Node<T> next = null;
		
		public Node(T d) {
			this.data = d;
		}
		public Node() {}
		
		public T getData() {
			return data;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public void setNext(Node<T> n) {
			next = n;
		}
	}
	
	Node<T> head = new Node<T>();
	Node<T> tail = head;
	Node<T> preTail = null;
	
	void pushBack(T d) {
		Node<T> newTail = new Node<T>(d);
		tail.next = newTail;
		preTail = tail;
		tail = newTail;
	}
	
	Node<T> popBack() throws NullPointerException {
		Node<T> popped = new Node<T>(tail.getData());
		System.out.println(String.format("%b %d %d",tail == head, tail.getData(), head.getData()));
		if (tail == head) {
			throw new NullPointerException("List is empty");
		}
		if (preTail.getNext() == null) {
			tail = head;
		}
		preTail.setNext(null);
		tail = preTail;
		return popped;
	}
	
	Node<T> popFront() throws NullPointerException {
		if (head.next != null) {
			Node<T> popped = head.getNext();
			head.next = head.getNext().getNext();
			return popped;
		} else {
			throw new NullPointerException("List is empty");
		}
	}
	
	
	void print() {
		Node<T> curr = head.next;
		while (curr != null) {
			System.out.print(curr.getData() + " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
		list.pushBack(10);
		list.pushBack(20);
		list.popBack();
		list.popBack();
		list.popBack();
		list.popBack();
	}
}
