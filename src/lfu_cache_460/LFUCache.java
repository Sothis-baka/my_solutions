package lfu_cache_460;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

class LFUCache {
    /*
        Use a map to save a DoubleLinkedList for each count.
        Use a map to save the key and corresponding node.

        When add a node.
        If the node already exists,
        increase the count, move it to corresponding list
        Else,
        Add a new node with count 1.
        If the list exceeds the capacity, remove the first node on list with min count

        When get a node,
        If the node doesn't exists, return -1
        else, increase the count, move the node. Return the value

        minCount saves current min value of count with a non-empty list,
        when we add a new node, the minCount is set to 1
        when we move a node, we check if it's in the minCount list, if so, if it's the only child of that list, increase the minCount
     */

    public static class Node{
        Node prev, next;
        int key, val, count;

        Node(int key, int val, int count){
            this.key = key;
            this.val = val;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("key: %d, value: %d, count: %d\t", key, val, count);
        }
    }


    static class DoubleLinkedList{
        Node start, end;
        int count;

        DoubleLinkedList(int count) {
            this.count = count;

            start = new Node(0, 0, count);
            end = new Node(0, 0, count);
            start.next = end;
            end.prev = start;
        }

        void addNode(Node node){
            this.end.prev.next = node;
            node.prev = this.end.prev;
            this.end.prev = node;
            node.next = this.end;
        }

        int removeFirst(){
            int key = this.start.next.key;
            this.start.next.next.prev = this.start;
            this.start.next = this.start.next.next;
            return key;
        }

        static void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        boolean isEmpty(){
            return this.start.next == this.end;
        }
    }

    Map<Integer, Node> nodeMap;
    Map<Integer, DoubleLinkedList> countMap;

    int capacity, minCount;

    public LFUCache(int capacity) {
        this.nodeMap = new HashMap<>();
        this.countMap = new HashMap<>();
        this.capacity = capacity;

        this.countMap.put(1, new DoubleLinkedList(1));
    }

    public int get(int key) {
        if(capacity == 0) return -1;

        if(!this.nodeMap.containsKey(key)) return -1;

        Node node = this.nodeMap.get(key);
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        if(this.nodeMap.containsKey(key)){
            Node node = this.nodeMap.get(key);
            node.val = value;
            updateNode(node);
        }else{
            // Check if it's at capacity
            if(this.nodeMap.size() == capacity){
                // Remove one from minCount list
                int removingKey = this.countMap.get(minCount).removeFirst();
                this.nodeMap.remove(removingKey);
            }

            Node node = new Node(key, value, 1);
            this.nodeMap.put(key, node);
            this.countMap.get(1).addNode(node);
            this.minCount = 1;
        }
    }

    private void updateNode(Node node){
        int count = node.count;
        // Remove current node from its list
        DoubleLinkedList.remove(node);
        // Add it to the next list
        // Init if doesn't exist a list for new count
        this.countMap
                .computeIfAbsent(count + 1, k -> new DoubleLinkedList(count + 1))
                .addNode(node);
        node.count++;

        // Update minCount if necessary
        if(minCount == count && this.countMap.get(count).isEmpty()) minCount++;
    }

    public static void main(String[] args){
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        System.out.println(cache.nodeMap);
        cache.put(2, 2);
        System.out.println(cache.nodeMap);
        cache.get(1);
        System.out.println(cache.nodeMap);
        cache.put(3, 3);
        System.out.println(cache.nodeMap);
        cache.get(2);
        System.out.println(cache.nodeMap);
        cache.get(3);
        System.out.println(cache.nodeMap);
        cache.put(4, 4);
        System.out.println(cache.nodeMap);
        cache.get(1);
        System.out.println(cache.nodeMap);
        cache.get(3);
        System.out.println(cache.nodeMap);
        cache.get(4);
        System.out.println(cache.nodeMap);
    }
}