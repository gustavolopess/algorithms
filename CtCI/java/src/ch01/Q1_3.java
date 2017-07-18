package ch01;

public class Q1_3 {
	
	private static int getRealLen(char[] str) {
		for (int i = str.length-1; i >= 0; i--) {
			if (str[i] != ' ') return i+1;
		}
		return 0;
	}
	
	
	public static void URLify(char[] str) {
		int totalLen = str.length, realLen = getRealLen(str);
		for(int i = realLen-1, j = totalLen-1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[j--] = '0';
				str[j--] = '2';
				str[j--] = '%';
			} else {
				str[j--] = str[i];
			}
		}
	}
	
	
	private static String toString(char[] arr) {
		StringBuilder sb = new StringBuilder();
		for (char c : arr) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		char[] word = "URLified string :    ".toCharArray();
		char[] word2 = "Mr John Smith    ".toCharArray();
		Q1_3.URLify(word);
		Q1_3.URLify(word2);
		System.out.println(toString(word));
		System.out.println(toString(word2));
	}

}
