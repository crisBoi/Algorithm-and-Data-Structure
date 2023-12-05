package StringQuestions;

import java.util.HashMap;
import java.util.Map;

public class Solution2423 {
    public static void main(String[] args) {
        System.out.println("" + isPossible("abbcc"));
    }

    static boolean isPossible(String st) {
        HashMap<Character, Integer> occurrence = new HashMap<>();


        for (Character ch : st.toCharArray()) {
            occurrence.put(ch, occurrence.getOrDefault(ch, 0) + 1);
        }

        int average = (int) Math.ceil((double) st.length() / occurrence.size());

        if (average == 0) return false;

        int count = 0;

        for (Map.Entry<Character, Integer> entry : occurrence.entrySet()) {
            if (entry.getValue() - 1 == average) {
                count++;
            }
        }



        return (count == 1 || (count == 0 && average == 1)) ;
    }
}

