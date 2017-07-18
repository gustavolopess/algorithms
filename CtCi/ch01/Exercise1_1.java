import java.lang.*;
import java.io.*;

class Exercise1_1 {

    public static Boolean isUnique(String word) {
        long firstHalf = 0, secondHalf = 0, checker;
        for (int i = 0; i < word.length(); i++) {
            int c = (int)word.charAt(i);
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
        System.out.println(Exercise1_1.isUnique("gustavo lopes"));
    } 
}