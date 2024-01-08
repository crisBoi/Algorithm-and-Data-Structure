package BackTracking;

import java.util.*;

public class LetterCombinationOfAPhoneNumber17 {
    public static void main(String[] args) {
        List<String> test1 = Arrays.asList(new String[]{"abc", "ef", "ghi"});
        String test2 = "23";
        String test3 = "";
        String test4 = "2";


        Sol17 sol = new Sol17();
        sol.helper(test4);
    }
}

class Sol17 {
    void backTrack(int currentString, List<String> input, StringBuilder str, List<String> res) {
        if (currentString == input.size()) {
           if (!str.isEmpty()) {
               res.add(str.toString());
           }
            return;
        }

        for (int i = 0; i < input.get(currentString).length(); i++) {
            str.append(input.get(currentString).charAt(i));
            backTrack(currentString + 1, input, str, res);
            str.deleteCharAt(str.length() - 1);
        }
    }

    void helper(String s) {
        HashMap<Character, String> numToAlpha = new HashMap<>();
        numToAlpha.put('2', "abc");
        numToAlpha.put('3', "def");
        numToAlpha.put('4', "ghi");
        numToAlpha.put('5', "jkl");
        numToAlpha.put('6', "mno");
        numToAlpha.put('7', "pqrs");
        numToAlpha.put('8', "tuv");
        numToAlpha.put('9', "wxyz");

        List<String> input = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            input.add(numToAlpha.get(s.charAt(i)));
        }

        print(input);
    }

    void print(List<String> input) {
        List<String> res = new ArrayList<>();

        backTrack(0, input, new StringBuilder(), res);

        System.out.println("res: " + Arrays.toString(res.toArray()));
    }
}
