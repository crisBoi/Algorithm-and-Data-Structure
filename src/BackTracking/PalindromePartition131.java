package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartition131 {
    public static void main(String[] args) {
        String test1 = "aab";
        String test2 = "caabbd";
        String test3 = "abc";
        String test4 = "abcd";
        String test5 = "rpopt";

        Sol131 sol = new Sol131();
        sol.print(sol.helper(test5));
    }
}

class Sol131 {

    List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add(new ArrayList<>());
            return res;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i + 1)) {
                for (List<String> list: partition(s.substring(i + 1))) {
                    list.add(0, s.substring(0, i + 1));
                    res.add(list);
                }
            }
        }

        return res;
    }

    boolean isPalindrome(String s, int n) {
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }
        return true;
    }

    void print(List<List<String>> res) {
        System.out.print("[");
        for (List<String> list: res) {
            System.out.print(Arrays.toString(list.toArray()));
        }
        System.out.println("]");
    }

    void print(String s) {
        List<List<String>> ans = partition(s);

        for (List<String> list: ans) {
            System.out.print(Arrays.toString(list.toArray()));
        }
        System.out.println();
    }

    List<List<String>> helper(String s) {
        List<List<String>> result = new ArrayList<>();

        if (s.isBlank() || s.isEmpty()) {
            return result;
        }

        backTrack(result, new ArrayList<>(), s);
        return result;
    }

    void backTrack(List<List<String>> result, List<String> parts, String s) {
        if (s.isEmpty() || s.isBlank()) {
            result.add(new ArrayList<>(parts));
            return;
        }


        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);

            if (!isPalindrome(temp)) continue;

            parts.add(temp);
            backTrack(result, parts, s.substring(i));
            parts.remove(parts.size() - 1);
        }
    }

    boolean isPalindrome(String s) {
        int l = 0, j = s.length() - 1;

        while (l <= j) {
            if (s.charAt(l) != s.charAt(j)) return false;
            l++;
            j--;
        }

        return true;
    }

}
