package LRU_cache_146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {
    Map<Integer, Integer> map = null;

    public LRUCache(int capacity) {
        map = new myLinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if(map.containsKey(key))
            return map.get(key);
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    private static class myLinkedHashMap<K, V> extends LinkedHashMap<K, V>{
        int max;

        myLinkedHashMap(int cap){
            super(cap, 0.75f, true);
            this.max = cap;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > this.max;
        }
    }
}
