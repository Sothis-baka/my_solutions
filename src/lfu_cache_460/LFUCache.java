package lfu_cache_460;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {
    Map<Integer, Integer> map;
    Map<Integer, Integer> freq;
    TreeMap<Integer, LinkedList<Integer>> counts;
    int cap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.freq = new HashMap<>();
        this.counts = new TreeMap<>();
    }

    public int get(int key) {
        if(cap == 0){
            return -1;
        }

        if(this.map.containsKey(key)){
            update(key);
            return map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cap == 0){
            return;
        }

        if(map.containsKey(key)){
            map.put(key, value);
            update(key);
        }else{
            if(map.size() == cap){
                int val = counts.firstEntry().getValue().removeFirst();
                map.remove(val);
                freq.remove(val);
                if(counts.firstEntry().getValue().isEmpty()){
                    counts.remove(counts.firstKey());
                }
            }
            map.put(key, value);
            freq.put(key, 1);
            counts.computeIfAbsent(1, k -> new LinkedList<>()).offer(key);
        }
    }

    private void update(int key){
        int count = freq.get(key);
        freq.put(key, count + 1);
        counts.get(count).remove(Integer.valueOf(key));
        if(counts.get(count).isEmpty()) counts.remove(count);
        counts.computeIfAbsent(count + 1, k -> new LinkedList<>()).offer(key);
    }

    public static void main(String[] args){
        LFUCache lfu = new LFUCache(2);
        lfu.put(1,1);
        System.out.println(lfu.counts);
        lfu.put(2,2);
        System.out.println(lfu.counts);
        System.out.println(lfu.get(1));
        System.out.println(lfu.counts);
        lfu.put(3,3);
        System.out.println(lfu.counts);
        System.out.println(lfu.get(2));
        System.out.println(lfu.counts);
        System.out.println(lfu.get(3));
        System.out.println(lfu.counts);
        lfu.put(4,4);
        System.out.println(lfu.counts);
        System.out.println(lfu.get(1));
        System.out.println(lfu.counts);
        System.out.println(lfu.get(3));
        System.out.println(lfu.counts);
        System.out.println(lfu.get(4));
        System.out.println(lfu.counts);
    }
}
