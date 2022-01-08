package word_search_79;

/*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class Main {
    public static boolean exist(char[][] board, String word) {
        int height = board.length, width = board[0].length;
        char initial = word.charAt(0);

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(board[i][j] == initial){
                    boolean[][] cache = new boolean[height][width];
                    // Mark as visited
                    cache[i][j] = true;
                    if(searchHelper(board, cache, i, j, word, 1)){
                        return true;
                    }
                    cache[i][j] = false;
                }
            }
        }

        return false;
    }

    private static boolean searchHelper(char[][] board, boolean[][] cache, int x, int y, String word, int index){
        // Fully matched
        if(index == word.length()){
            return true;
        }

        // Find next matched character and it's not visited
        char cur = word.charAt(index);
        if(x != 0){
            if(board[x-1][y] == cur && !cache[x-1][y]){
                cache[x-1][y] = true;
                if(searchHelper(board, cache, x-1, y, word, index+1)){
                    return true;
                }
                cache[x-1][y] = false;
            }
        }

        if(y != board[0].length - 1){
            if(board[x][y+1] == cur && !cache[x][y+1]){
                cache[x][y+1] = true;
                if(searchHelper(board, cache, x, y+1, word, index+1)){
                    return true;
                }
                cache[x][y+1] = false;
            }
        }

        if(x != board.length - 1){
            if(board[x+1][y] == cur && !cache[x+1][y]){
                cache[x+1][y] = true;
                if(searchHelper(board, cache, x+1, y, word, index+1)){
                    return true;
                }
                cache[x+1][y] = false;
            }
        }

        if(y != 0){
            if(board[x][y-1] == cur && !cache[x][y-1]){
                cache[x][y-1] = true;
                if(searchHelper(board, cache, x, y-1, word, index+1)){
                    return true;
                }
                cache[x][y-1] = false;
            }
        }

        return false;
    }

    public static void main(String[] args){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCEDF"));
    }
}
