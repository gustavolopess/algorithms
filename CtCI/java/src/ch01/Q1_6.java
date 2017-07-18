package ch01;

public class Q1_6 {
	
	public static String stringCompression(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i, k = 1; j < str.length() && str.charAt(j) == str.charAt(i); j++, k++) count = k;
			i += count-1;
			sb.append(str.charAt(i));
			sb.append(count);
			
		}
		return sb.length() < str.length() ? sb.toString() : str;
	}
	
	public static void main(String[] args) {
		System.out.println(Q1_6.stringCompression("aabcccccaaa"));
		System.out.println(Q1_6.stringCompression("aa"));
		System.out.println(Q1_6.stringCompression("aac"));
		System.out.println(Q1_6.stringCompression("aaccc"));
	}
	
}
