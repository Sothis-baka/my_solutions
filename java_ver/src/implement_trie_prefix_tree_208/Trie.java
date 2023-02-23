package implement_trie_prefix_tree_208;

import structures.ListNode;

import java.util.*;

/*
    A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 */
public class Trie {
    private static class Node{
        Map<Character, Node> children;

        Node(){
            this.children = new HashMap<>();
        }
    }

    Node head;

    public Trie() {
        this.head = new Node();
    }

    public void insert(String word) {
        Node pt = this.head;
        int length = word.length();
        for(int i=0; i<length; i++){
            char ch = word.charAt(i);
            if(pt.children.containsKey(ch)){
                pt = pt.children.get(ch);
            }else{
                Node next = new Node();
                pt.children.put(ch, next);
                pt = next;
            }
        }
        pt.children.put('\0', null);
    }

    public boolean search(String word) {
        Node pt = this.head;
        int length = word.length();
        for(int i=0; i<length; i++){
            char ch = word.charAt(i);
            if(pt.children.containsKey(ch)){
                pt = pt.children.get(ch);
            }else{
                return false;
            }
        }

        return pt.children.containsKey('\0');
    }

    public boolean startsWith(String prefix) {
        Node pt = this.head;
        int length = prefix.length();
        for(int i=0; i<length; i++){
            char ch = prefix.charAt(i);
            if(pt.children.containsKey(ch)){
                pt = pt.children.get(ch);
            }else{
                return false;
            }
        }

        return true;
    }
}
