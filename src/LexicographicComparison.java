public class LexicographicComparison {
    public static void main(String[] args) {
        String st1 = "a";
        String st2 = "A";

        Lexico lex = new Lexico();

        System.out.println(lex.compare(st1, st2));
    }
}

class Lexico {
    String compare(String st1, String st2) {
        if (st1.compareTo(st2) == 0) {
            return "Same string";
        } else if (st1.compareTo(st2) > 0) {
            return st1 + " is greater than " + st2;
        } else {
            return st1 + " is smaller than " + st2;
        }
    }

}