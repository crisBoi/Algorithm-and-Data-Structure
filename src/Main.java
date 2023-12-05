import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] str = {"a"};

    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {

        String previous = null;

        int prefixLength = 0;


        for (String current : strs) {

            int commonLength = 0;

            if (previous == null) {
                previous = current;
            } else {

                prefixLength = Math.min(previous.length(), current.length());

                for (int i = 0; i < prefixLength; i++) {
                    if (current.charAt(i) == previous.charAt(i)) {
                        commonLength++;
                    } else {
                        break;
                    }
                }
                if (commonLength == 0) return "";

                prefixLength = commonLength;
                previous = current.substring(0, prefixLength);
            }
        }

        return previous;
    }

    String longestCommonPrefixSort(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int minIndex = Math.min(first.length(), last.length());
        int prefixLength = 0;

        for (int i = 0; i < minIndex; i++) {
            if (first.charAt(i) == last.charAt(i)) {
                prefixLength++;
            } else {
                break;
            }
        }

        if (prefixLength == 0) return "";

        return first.substring(0, prefixLength);
    }
}
