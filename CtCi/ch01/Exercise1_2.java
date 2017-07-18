import java.lang.*;
import java.util.*;

class Exercise1_2 {

    public static Boolean checkPermutation(String w1, String w2) {
        if (w1.length() != w2.length()) return false;
        int[] count = new int[3000];
        for (int i = 0; i < w1.length(); i++) {
            count[(int)w1.charAt(i)]++;
            count[(int)w2.charAt(i)]++;
        }
        for (int i = 0; i < w1.length(); i++) {
            if (count[(int)w2.charAt(i)] < 2) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(Exercise1_2.checkPermutation("banana", "nabana"));
        System.out.println(Exercise1_2.checkPermutation("banana", "nacana"));
    }
}