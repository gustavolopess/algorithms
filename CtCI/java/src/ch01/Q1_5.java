package ch01;

public class Q1_5 {
	
	private static int getDiffs(String gt, String lt) {
		boolean[] inLt = new boolean[256];
		int diffs = 0;
		for (int i = 0; i < lt.length(); i++) inLt[lt.charAt(i)] = true;
		for (int i = 0; i < gt.length(); i++) diffs += (inLt[gt.charAt(i)] ? 0 : 1);
		return diffs;
	}

	public static boolean oneWay(String w1, String w2) {
		int diffs = Math.max(w1.length(), w2.length()) - Math.min(w1.length(), w2.length());
		if (diffs > 1) return false;
		if (w1.length() > w2.length()) diffs += getDiffs(w1, w2) == 1 ? 0 : 1;
		else if (w1.length() < w2.length()) diffs += getDiffs(w2, w1) == 1 ? 0 : 1;
		else diffs += getDiffs(w1, w2);
		return diffs <= 1;
	}
	
	public static void main(String[] args) {
		System.out.println(Q1_5.oneWay("pale", "ple"));
		System.out.println(Q1_5.oneWay("pales", "pale"));
		System.out.println(Q1_5.oneWay("pale", "bale"));
		System.out.println(Q1_5.oneWay("pale", "bake"));

	}
	
}
