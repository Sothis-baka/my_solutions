package word_break_ii_140;

import java.util.*;

/*
    Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
    Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class Main {
    static class Trie{
        Trie[] children;

        Trie(){
            // Save corresponding tries for 26 chars, the last one is to confirm it's a complete string
            children = new Trie[27];
        }

        // Helper function to save a string into tTrie
        void add(String s, int index){
            if(index == s.length()) this.children[26] = new Trie();
            else {
                int indexOfCh = s.charAt(index) - 'a';
                if(this.children[indexOfCh] == null) this.children[indexOfCh] = new Trie();
                this.children[indexOfCh].add(s, index + 1);
            }
        }

        // Helper function to find all available substrings str that target[index: end] starts with str
        List<String> matchedStrings(String target, int index){
            List<String> result = new ArrayList<>();

            // It's a complete string
            if(this.children[26] != null) result.add("");

            // Reached end
            if(index == target.length()) return result;

            // Find all future strings
            char ch = target.charAt(index);
            int indexOfCh = ch - 'a';
            if(this.children[indexOfCh] != null){
                List<String> candidates = this.children[indexOfCh].matchedStrings(target, index + 1);
                for(String candidate: candidates) result.add(ch + candidate);
            }

            return result;
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        /*
            Construct a trie with wordDict to find all available strings from index i
         */
        Trie trie = new Trie();
        for(String word: wordDict) trie.add(word, 0);

        /*
            DFS
            Start from index i, find all strings from the pos.
            Recursively find all possible postfixes after those strings.
            DP
            Save the postfixes to avoid repeat visit
         */
        Map<Integer, List<String>> cache = new HashMap<>();

        return findAllResult(cache, s, 0, trie);
    }

    // Find the string results from index
    private List<String> findAllResult(Map<Integer, List<String>> cache, String target, int index, Trie trie){
        if(cache.containsKey(index)) return cache.get(index);

        List<String> result = new ArrayList<>();
        List<String> candidates = trie.matchedStrings(target, index);

        for(String candidate: candidates){
            // Complete search
            if(index + candidate.length() == target.length()){
                result.add(candidate);
                continue;
            }

            List<String> postfixes = findAllResult(cache, target, index + candidate.length(), trie);

            for(String postfix: postfixes){
                result.add(candidate + " " + postfix);
            }
        }

        cache.put(index, result);
        return result;
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(new Main().wordBreak("catsanddog", list));
    }
}
