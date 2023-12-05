package LinkedList.LFUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache460 {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);

        lfu.put(3, 1);
        lfu.put(2, 1);
        lfu.put(2, 2);
        lfu.put(4, 4);

        System.out.println(lfu.get(2) + "");
    }
}
class LFUCache {
    Map<Integer, Pair> cache;
    Map<Integer, LinkedHashSet<Integer>> freq;


    int minF;
    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freq = new HashMap<>();
        minF = 0;
        this.capacity = capacity;
    }

    void insert(int key, int frequency, int value) {
        cache.put(key, new Pair(frequency, value));
        freq.putIfAbsent(frequency, new LinkedHashSet<>());
        freq.get(frequency).add(key);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Pair freqToVal = cache.get(key);

        freq.get(freqToVal.frequency).remove(key);
        if (freq.get(freqToVal.frequency).isEmpty()) {
            freq.remove(freqToVal.frequency);

            if (minF == freqToVal.frequency) {
                minF++;
            }
        }

        insert(key, freqToVal.frequency + 1, freqToVal.value);
        return freqToVal.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        Pair freqToVal = cache.get(key);

        if (cache.containsKey(key)) {
            cache.put(key, new Pair(freqToVal.frequency, value));
            get(key);
            return;
        }

        if (capacity == cache.size()) {
            int deleteKey = freq.get(minF).iterator().next();

            cache.remove(deleteKey);
            freq.get(minF).remove(deleteKey);

            if (freq.get(minF).isEmpty()) {
                freq.remove(minF);
            }
        }
        minF = 1;
        insert(key, 1, value);
    }
}

class Pair {
    int frequency;
    int value;

    Pair(int f, int s) {
        frequency = f;
        value = s;
    }
    int getFrequency() { return frequency; }
    int getValue() { return value; }

}