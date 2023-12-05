package TwoPointers;

public class TwoPointers125 {
    public static void main(String[] args) {
        Sol125 sol = new Sol125();
        sol.isValild("A man, a plan, a canal: Panama");
    }
}

class Sol125 {
    public boolean isValild(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (isAlphabet(s.charAt(i)) || isNumber(s.charAt(i))) {
                builder.append(s.charAt(i));
            }
        }



        for (int i = 0; i < builder.length() / 2; i++) {
            if (Character.toLowerCase(builder.charAt(i)) != Character.toLowerCase(builder.charAt(builder.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    boolean isValidOptimized(String s) {
        int currentStart = 0;
        int currentEnd = s.length() - 1;

        while (currentStart <= currentEnd) {
            if (!Character.isLetterOrDigit(s.charAt(currentStart))) {
                currentStart++;
            } else if (!Character.isLetterOrDigit(s.charAt(currentEnd))) {
                currentEnd--;
            } else {
                if (Character.toLowerCase(s.charAt(currentStart)) != Character.toLowerCase(s.charAt(currentEnd))) {
                    return false;
                }
                currentStart++;
                currentEnd--;
            }
        }
        return true;
    }

    boolean isAlphabet(char c) {
       if ((c > 96 && c < 123) || (c > 64 && c < 91)) {
           return true;
       }
       return false;
    }

    boolean isNumber(char c) {
        if (c > 47 && c < 58) {
            return true;
        }
        return false;
    }
}
