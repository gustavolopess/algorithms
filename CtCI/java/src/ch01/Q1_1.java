package ch01;

public class Q1_1 {

	public static boolean isUnique(String word) {
		long firstHalf = 0, secondHalf = 0, checker;
		for (char c : word.toCharArray()) {
			if (c < 64) {
				checker = firstHalf;
				firstHalf |= (1 << c);
			} else {
				c %= 64;
				checker = secondHalf;
				secondHalf |= (1 << c);
			}
			if ((checker & (1 << c)) > 0) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Q1_1.isUnique("gustavo"));
	}

}
