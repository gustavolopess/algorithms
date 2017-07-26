package ch02;

class CustomLinkedListQ3<T> extends CustomLinkedList<T> {
	
	public void deleteNode(CustomLinkedList<T>.Node<T> n) {
		CustomLinkedList<T>.Node<T> prev = n.getPrev(), next = n.getNext();
		prev.setNext(next);
		next.setPrev(prev);
	}
	
}

public class Q2_3 {
	
	public static void main(String[] args) {
		CustomLinkedListQ3<Integer> list = new CustomLinkedListQ3<Integer>();
		list.pushAllBack(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} );
		System.out.println(list);
		list.deleteNode(list.head.getNext().getNext().getNext());
		System.out.println(list);
	}
	
}
