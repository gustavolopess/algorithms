package ch02;
import java.util.HashMap;
import java.util.HashSet;

import ch02.CustomLinkedList;


class CustomLinkedListWithDeletion<T> extends CustomLinkedList<T> {
	
	
	public void deleteDups() {
		CustomLinkedList<T>.Node<T> curr = this.head.getNext(); 
		HashSet<T> set = new HashSet<T>();
		while (curr != tail) {
			if (!set.contains(curr.getData())) set.add(curr.getData());
			else {
				curr.getPrev().setNext(curr.getNext());
				curr.getNext().setPrev(curr.getPrev());
				size--;
			}
			curr = curr.getNext();
		}
	}
}


public class Q2_1  {
	
	public static void main(String[] args) {
		CustomLinkedListWithDeletion<Integer> list = new CustomLinkedListWithDeletion<Integer>();
		list.pushAllBack(new Integer[] {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 10, 2, 1, 1, 1});
		System.out.println(list);
		list.deleteDups();
		System.out.println(list);
	}
	
}
