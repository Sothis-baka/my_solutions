package LRU_cache_146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
    /*
        LinkedHashMap in Java Standard library, we can just override the removeEldestEntry method
        Or use a LinkedList to save pair positions, and use a hashmap to save pairs
     */

    static class ListNode{
        ListNode prev, next;
        int key, value;

        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    ListNode start, end;
    HashMap<Integer, ListNode> cache;
    int max;

    private void moveToEnd(ListNode cur){
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

        cur.prev = end.prev;
        cur.next = end;
        end.prev.next = cur;
        end.prev = cur;
    }

    private ListNode removeFirst(){
        ListNode node = start.next;
        start.next = start.next.next;
        start.next.prev = start;
        return node;
    }

    public LRUCache(int capacity) {
        this.start = new ListNode(0, 0);
        this.end = new ListNode(0, 0);
        this.start.next = this.end;
        this.end.prev = this.start;
        this.cache = new HashMap<>();
        this.max = capacity;
    }

    public int get(int key) {
        ListNode cur = cache.get(key);
        if(cur == null) return -1;

        // It's now most recent one
        moveToEnd(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        ListNode cur = cache.get(key);

        if(cur == null){
            // Ensure space
            if(cache.size() == max){
                cur = removeFirst();
                cache.remove(cur.key);
            }

            ListNode newNode = new ListNode(key, value);
            newNode.next = end;
            newNode.prev = end.prev;
            end.prev.next = newNode;
            end.prev = newNode;

            cache.put(key, newNode);
        }else{
            cur.value = value;
            moveToEnd(cur);
        }
    }
}
