package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TimeBaseKeyValueStore981 {
    public static void main(String[] args) {
        TimeMap t = new TimeMap();
        //Test case 1
//        t.set("foo", "bar", 1);
//        System.out.println("get: foo, 1 " + t.get("foo", 1));
//        System.out.println("get: foo, 3 " + t.get("foo", 3));
//        t.set("foo", "bar2", 4);
//        System.out.println("get: foo, 4 " + t.get("foo", 4));
//        System.out.println("get: foo, 5 " + t.get("foo", 5));

        //Test case 2
//        t.set("love", "high", 10);
//        t.set("love", "low", 20);
//        System.out.println("get: love, 5 " + t.get("love", 5));
//        System.out.println("get: love, 10 " + t.get("love", 10));
//        System.out.println("get: love, 15 " + t.get("love", 15));
//        System.out.println("get: love, 20 " + t.get("love", 20));
//        System.out.println("get: love, 25 " + t.get("love", 25));

        //test case 3
        t.set("a", "bar", 1);
        t.set("x", "b", 3);
        System.out.println("get: b, 3 " + t.get("b", 3));
        t.set("foo", "bar2", 4);
        System.out.println("get: foo, 4 " + t.get("foo", 4));
        System.out.println("get: foo, 5 " + t.get("foo", 5));

       /* int[] test1 = new int[] {1, 2, 4, 6, 8, 9};
        t.getIndex(test1, 0);
        t.getIndex(test1, 2);
        t.getIndex(test1, 12);
        t.getIndex(test1, 7);
        t.getIndex(test1, 3);*/
//        System.out.println("res 0: " + t.getIndex());
    }
}

class TimeMap {
    private HashMap<String, List<Pair>> hashMap;
    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(new Pair(value, timestamp));
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(value, timestamp));

            hashMap.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key)) {
            return "";
        }

        List<Pair> list = hashMap.get(key);

        return getValue(list, timestamp);
    }

    private String getValue(List<Pair> list, int timeStamp) {
        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int m =  (l + r) / 2;

            if (list.get(m).timeStamp == timeStamp) {
                return list.get(m).value;
            } else if (timeStamp > list.get(m).timeStamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (r < 0) {
            return "";
        } else if (l > list.size() - 1) {
            return list.get(list.size() - 1).value;
        } else {
            return list.get(r).value;
        }
    }

    class Pair {
        String value; int timeStamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timeStamp = timestamp;
        }
    }
}

