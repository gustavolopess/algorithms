package ch02;
import ch02.CustomLinkedList;

class CustomLinkedListQ2<T> extends CustomLinkedList<T> {
	public CustomLinkedListQ2<T> kToLast(int k) {
		CustomLinkedListQ2<T> newList = new CustomLinkedListQ2<T>();
		CustomLinkedList<T>.Node<T> curr = head.getNext();
		for (int i = 1; curr != tail; curr = curr.getNext(), i++) {
			if (i >= k) newList.pushBack(curr.getData());
		}
		return newList;
	}
}


public class Q2_2 {
	
	public static void main(String[] args) {
		CustomLinkedListQ2<Integer> list = new CustomLinkedListQ2<Integer>();
		list.pushAllBack(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7});
		System.out.println(list.kToLast(2));
	}
	

}
