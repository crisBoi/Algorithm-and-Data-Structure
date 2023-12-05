package LinkedList.LRUCache;

import org.w3c.dom.Node;

import java.util.*;

public class LRUCahe146 {
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);

        lruCache.get(2);
        lruCache.put(2,6);

        System.out.println("lru get" + lruCache.get(1));

        lruCache.put(1, 5);

//        System.out.println("lru get" + lruCache.get(2));

        lruCache.put(1, 2);

        System.out.println("lru get" + lruCache.get(1));
        System.out.println("lru get" + lruCache.get(2));
//        System.out.println("lru get" + lruCache.get(4));


    }
}

class LRUCache {
    HashMap<Integer, DNode> cache;
    DNode left;
    DNode right;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        left = new DNode(0, 0);
        right = new DNode(0, 0);

        left.nxt = right;
        right.prev = left;
    }

    void insert(DNode node) {

        node.nxt = left.nxt;
        node.prev = left;

        left.nxt.prev = node;
        left.nxt = node;

    }

    void remove(DNode leastUsedNode) {
        leastUsedNode.prev.nxt = leastUsedNode.nxt;
        leastUsedNode.nxt.prev = leastUsedNode.prev;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        int val = cache.get(key).val;
        remove(cache.get(key));
        cache.remove(key);

        DNode newNode = new DNode(key, val);
        cache.put(key, newNode);

        insert(newNode);

        return val;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            remove(cache.get(key));
            cache.remove(key);
        }

        DNode newNode = new DNode(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            cache.remove(right.prev.key);
            remove(right.prev);
        }
    }

}

/*class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    HashSet<Integer> priority = new HashSet<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (cache.isEmpty()) return -1;

        if (!cache.containsKey(key)) {
            return -1;
        } else {
            int val = cache.get(key);
            priority.remove(key);
            priority.add(key);
            return val;
        }
    }

    public void put(int key, int value) {
        if (cache.size() == capacity) {
            int i = 0;
            int rmKey = -1;

            for (Integer k: cache.keySet()) {
                if (i == capacity - 1) {
                    rmKey = k;
                }
                i++;
            }

            cache.remove(rmKey);
        }

        if (cache.containsKey(value)) {
            cache.remove(key);
        }
        cache.put(key, value);
    }

   *//* class Pair {
        int key;
        int value;

        Pai
    }*//*
}*/

class DNode {
    int key;
    int val;

    DNode prev;
    DNode nxt;

    DNode(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        nxt = null;
    }
}
