package design_search_autocomplete_system_642;

import java.util.*;

public class AutocompleteSystem {
    static class Trie{
        Map<Character, Trie> children;
        Set<String> visited;

        Trie(){
            this.children = new HashMap<>();
            this.visited = new HashSet<>();
        }

        void insert(String str, int index){
            visited.add(str);
            if(index == str.length()) children.put('\b', null);
            else this.children.computeIfAbsent(str.charAt(index), k->new Trie()).insert(str, index + 1);
        }

        Trie searchTrie(String str, int index){
            if(index == str.length()) return this;
            if(!this.children.containsKey(str.charAt(index))) return null;
            return this.children.get(str.charAt(index)).searchTrie(str, index+1);
        }
    }

    String curInput;
    Map<String, Integer> counts;
    Trie trie;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.curInput = "";
        this.counts = new HashMap<>();
        this.trie = new Trie();
        for(int i=0; i<sentences.length; i++) {
            counts.put(sentences[i], times[i]);
            this.trie.insert(sentences[i], 0);
        }
    }

    public List<String> input(char c) {
        this.curInput += c;
        return getSuggestions();
    }

    private List<String> getSuggestions() {
        Trie target = this.trie.searchTrie(curInput, 0);
        if(target == null) return new ArrayList<>();
        List<String> candidates = new ArrayList<>(target.visited);
        if(candidates.size() <= 3) return candidates;
        candidates.sort((a, b) -> this.counts.get(b) - this.counts.get(a));
        return candidates.subList(0, 3);
    }

    public static void main(String[] args){
        AutocompleteSystem as = new AutocompleteSystem(new String[]{"i love you", "island","ironman", "i love leetcode"}, new int[]{5,3,2,2});
        System.out.println(as.input('i'));
        System.out.println(as.input(' '));
        System.out.println(as.input('a'));
        System.out.println(as.input('#'));
    }
}
