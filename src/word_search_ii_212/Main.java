package word_search_ii_212;

import java.util.*;

/*
    Given an m x n board of characters and a list of strings words, return all words on the board.
    Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
public class Main {
    /*
        Trie structure
     */
    private static class TrieNode{
        TrieNode[] next;
        String word;

        TrieNode(){
            this.next = new TrieNode[26];
        }

        protected void insert(String word){
            TrieNode pt = this;

            char[] charArr = word.toCharArray();
            for(char ch: charArr){
                if(pt.next[ch-'a'] != null){
                    pt = pt.next[ch-'a'];
                }else{
                    TrieNode newTrie = new TrieNode();
                    pt.next[ch-'a'] = newTrie;
                    pt = newTrie;
                }
            }

            pt.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Save words as a trie tree
        TrieNode head = new TrieNode();
        for(String word: words){
            head.insert(word);
        }

        // Search tries on the board
        Set<String> result = new HashSet<>();
        int height = board.length, width = board[0].length;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                search(board, i, j, head, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void search(char[][] board, int i, int j, TrieNode trie, Set<String> result){
        char cur = board[i][j];
        // The cell is in process
        if(cur == '\0'){
            return;
        }

        TrieNode next = trie.next[cur - 'a'];
        if(next != null){
            if(next.word != null){
                result.add(next.word);
            }

            board[i][j] = '\0';

            if(i > 0){
                search(board, i-1, j, next, result);
            }

            if(i < board.length - 1){
                search(board, i+1, j, next, result);
            }

            if(j > 0){
                search(board, i, j-1, next, result);
            }

            if(j < board[0].length - 1){
                search(board, i, j+1, next, result);
            }

            board[i][j] = cur;
        }
    }
}
