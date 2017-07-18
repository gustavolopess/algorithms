package ch01;

public class Q1_2 {

	
	public static boolean checkPermutation(String w1, String w2) {
		if (w1.length() != w2.length()) return false;
		long firstHalf = 0, secondHalf = 0;
		for (int i = 0; i < w1.length(); i++) {
			char c1 = w1.charAt(i), c2 = w2.charAt(i);
			if (c1 >= 64) { 
				c1 %= 64;
				secondHalf ^= (1 << c1);
			} else {
				firstHalf ^= (1 << c1);
			}
			if (c2 >= 64) {
				c2 %= 64;
				secondHalf ^= (1 << c2);
			} else {
				secondHalf ^= (1 << c2);
			}			
		}
		return firstHalf == 0 && secondHalf == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(Q1_2.checkPermutation("banana", "nabana"));
		System.out.println(Q1_2.checkPermutation("banana", "nacana"));
	}
	
}
