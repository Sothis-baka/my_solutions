package word_search_ii_212;

import java.util.*;

/*
    Given an m x n board of characters and a list of strings words, return all words on the board.
    Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
public class Main {
    static class Trie{
        Trie[] children = new Trie[26];
        String str;

        void addWord(char[] chArr, int index){
            if(index == chArr.length){
                this.str = String.valueOf(chArr);
                return;
            }

            int chIndex = chArr[index] - 'a';

            // If there is no child with character ch, create one
            if(children[chIndex] == null)
                children[chIndex] = new Trie();

            // Recursively add all chars in str
            children[chIndex].addWord(chArr, index + 1);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();

        for(String word: words)
            root.addWord(word.toCharArray(), 0);

        // Start from each cell, do dfs
        List<String> result = new ArrayList<>();
        int height = board.length, width = board[0].length;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                dfs(root, board, i, j, height, width, result);
            }
        }

        return result;
    }

    private void dfs(Trie trie, char[][] board, int row, int col, int height, int width, List<String> result){
        char ch = board[row][col];
        // Visited or this character doesn't exist in current trie
        if(ch == '\0' || trie.children[ch - 'a'] == null) return;

        trie = trie.children[ch - 'a'];
        // It's a complete string
        if(trie.str != null) {
            // Save to result
            result.add(trie.str);
            // Prevent duplicate
            trie.str = null;
        }


        // Mark current cell as visited
        board[row][col] = '\0';

        // Continue searching
        if(row > 0) dfs(trie, board, row - 1, col, height, width, result);
        if(row < height - 1) dfs(trie, board, row + 1, col, height, width, result);
        if(col > 0) dfs(trie, board, row, col - 1, height, width, result);
        if(col < width - 1) dfs(trie, board, row, col + 1, height, width, result);

        // Change the cell back to origin
        board[row][col] = ch;
    }

    public static void main(String[] args){
        System.out.println(
                new Main().findWords(new char[][]{
                        {'a'}
                }, new String[]{
                        "a"
                })
        );
    }
}
