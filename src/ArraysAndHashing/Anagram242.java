package ArraysAndHashing;

import java.util.Arrays;

public class Anagram242 {
    public static void main(String[] args) {
        boolean[] x= new boolean[2];
        System.out.println("" + x[0] + ", " + x[1]);
    }
}

class AnagramSol {
    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sStr = s.toCharArray();
        Arrays.sort(sStr);

        char[] tStr = t.toCharArray();
        Arrays.sort(tStr);

        for (int i = 0; i < s.length(); i++) {
            if (sStr[i] != tStr[i]) {
                return false;
            }
        }

        return true;
    }

    boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int num: alphabet) {
            if (num != 0) return false;
        }

        return true;
    }
}
