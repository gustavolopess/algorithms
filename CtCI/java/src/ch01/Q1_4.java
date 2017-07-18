package ch01;

public class Q1_4 {
	
	
	public static boolean palindromePermutation(String word) {
		word = word.toLowerCase();
		int[] count = new int[256]; // ascii table 
		int odd = 0;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!Character.isLetter(ch)) continue;
			count[ch]++;
			if ((count[ch] & 1) > 0) odd++;
			else odd--;
		}
		return odd <= 1;
	}
	
	public static void main(String[] args) {
		System.out.println(Q1_4.palindromePermutation("Ratzs live on no evil starz"));
		System.out.println(Q1_4.palindromePermutation("Zeus was deified, saw Suez"));
		System.out.println(Q1_4.palindromePermutation("Gustavo Lopes de Souza"));
	}
}
