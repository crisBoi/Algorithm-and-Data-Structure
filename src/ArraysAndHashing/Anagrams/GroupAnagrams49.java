package ArraysAndHashing.Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        Sol49 sol = new Sol49();
//        System.out.println("" + sol.group(new String[]{"", "b"}));
        System.out.println();
        System.out.println("" + sol.groupOptimized(new String[]{"ddddddddddg","dgggggggggg"}));

        int x = ((int)'a') + 1;
        char ch = ((char) x);
        System.out.println("" + ch);
    }

}

class Sol49 {

    List<List<String>> groupOptimized(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String st: strs) {
            int[] count = new int[26];

            for (int i = 0; i < st.length(); i++) {
                count[st.charAt(i) - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    int alphabetAscii = ((int)'a') + i;
                    char alphabet = (char) alphabetAscii;
                    key.append(count[i]).append(alphabet);
                }
                System.out.println("key: " + key);
            }

            map.putIfAbsent(key.toString(), new ArrayList<>()); //["ddddddddddg","dgggggggggg"]
            map.get(key.toString()).add(st);
        }

        System.out.println("map: " + map);

        return new ArrayList<List<String>>(map.values());
    }

    boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        if ((s.isEmpty() && !t.isEmpty()) || (!s.isEmpty() && t.isEmpty())) return false;
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;

        }

        for (Integer num: count) {
            if (num != 0)
                return false;
        }

        return true;
    }

    List<List<String>> group(String[] str) {
        List<List<String>> result = new ArrayList<>();
        HashSet<Integer> index = new HashSet<>();

        for (int i = 0; i < str.length; i++) {
            if (!index.contains(i)) {

                List<String> list = new ArrayList<>();
                index.add(i);
                list.add(str[i]);

                for (int j = i + 1; j < str.length; j++) {

                    if (!index.contains(j)) {
                       if (isAnagram(str[i], str[j])) {
                           list.add(str[j]);
                           index.add(j);
                       }
                    }
                }

                result.add(list);
            }
        }

        return result;
    }

}
