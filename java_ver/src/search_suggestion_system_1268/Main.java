package search_suggestion_system_1268;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    You are given an array of strings products and a string searchWord.
    Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
    Return a list of lists of the suggested products after each character of searchWord is typed.
 */
public class Main {
    static class Trie {
        Trie[] children;
        LinkedList<String> suggestions;

        Trie(){
            this.children = new Trie[26];
            this.suggestions = new LinkedList<>();
        }
    }

    /*
        Helper function to add a word to the Trie
     */
    public void insertWord(Trie root, String str){
        Trie ptNode = root;
        for(char ch: str.toCharArray()){
            int chIndex = ch - 'a';
            if(ptNode.children[chIndex] == null)
                ptNode.children[chIndex] = new Trie();

            ptNode = ptNode.children[chIndex];
            ptNode.suggestions.offer(str);

            // Only keep 3 smallest
            ptNode.suggestions.sort(String::compareTo);
            while (ptNode.suggestions.size() > 3) ptNode.suggestions.removeLast();
        }
    }

    /*
        Helper function to find all suggestions based on the input step by step
     */
    private List<List<String>> getSuggestions(Trie root, String str){
        List<List<String>> suggestions = new ArrayList<>();

        Trie ptNode = root;
        for(char ch: str.toCharArray()){
            if(ptNode != null) ptNode = ptNode.children[ch - 'a'];

            suggestions.add(ptNode == null ? new ArrayList<>() : ptNode.suggestions);
        }

        return suggestions;
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();

        // Save all words
        for(String product: products)
            insertWord(root, product);

        // Find the suggestions
        return getSuggestions(root, searchWord);
    }
}