package battleships_in_a_board_419;

/*
    Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
    Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
 */
public class Main {
    public int countBattleships(char[][] board) {
        int height = board.length, width = board[0].length, count = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(board[i][j] == 'X' && (j == 0 || board[i][j-1] == '.') && (i==0 || board[i-1][j] == '.')){
                    count++;
                }
            }
        }
        return count;
    }

    /*public int countBattleships(char[][] board) {
        int height = board.length, width = board[0].length;
        boolean[][] visited = new boolean[height][width];

        int count = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    helper(board, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }


    private void helper(char[][] board, boolean[][] visited, int i, int j){
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir: dirs){
            int h = i + dir[0], w = j + dir[1];
            while (h >= 0 && h < board.length && w >= 0 && w < board[0].length && board[h][w] == 'X'){
                visited[h][w] = true;
                h += dir[0];
                w += dir[1];
            }
        }
    }*/
}
