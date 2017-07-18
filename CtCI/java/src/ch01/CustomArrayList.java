package ch01;

public class CustomArrayList<T> {
	// resize factor = 2
	private T elts[];
	private int idx;
	
	public CustomArrayList(int initialCapacity) {
		this.elts = (T[]) new Object[initialCapacity];
		this.idx = 0;
	}
	
	public CustomArrayList() {
		this(2);
	}
	
	public T add(T elt) {
		if (this.idx+1 == this.elts.length) resize();
		return this.elts[this.idx++] = elt;
	}
	
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < this.idx) return this.elts[index];
		else throw new IndexOutOfBoundsException(String.format("%d is an invalid index. Current list size is %d", index, this.idx));
	}
	
	public T put(int index, T value) throws IndexOutOfBoundsException {
		if (index < this.idx) return this.elts[index] = value;
		else throw new IndexOutOfBoundsException(String.format("%d is an invalid index. Current list size is %d", index, this.idx));
	}
	
	private void resize() {
		T temp[] = (T[]) new Object[(this.idx+1)*2];
		System.arraycopy(this.elts, 0, temp, 0, idx+1);
		this.elts = temp;
	}
	
	public void print() {
		for (T elt : this.elts) System.out.print(elt + " ");
		System.out.println();
	}
	
	public static void main(String args[]) {
        CustomArrayList<Integer> arr = new CustomArrayList<Integer>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(50);
        arr.print();
        arr.add(100);
        arr.put(4, -2);
        arr.print();
        System.out.println(arr.get(0));
    }
}

