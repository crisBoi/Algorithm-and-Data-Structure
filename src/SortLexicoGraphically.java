import java.lang.reflect.Array;
import java.util.Arrays;

public class SortLexicoGraphically {
    public static void main(String[] args) {
        String[] arr = {"Rab", "raa"};

        SortLexico sort = new SortLexico();
        sort.sort(arr);
    }
}

class SortLexico {
    void sort(String[] arr) {
        Arrays.sort(arr);

        for (String item: arr) {
            System.out.println(item);
        }
    }
}