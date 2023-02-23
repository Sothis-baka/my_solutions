package n_queens_ii_52;

import java.util.*;

public class Main {
    public int totalNQueens(int n) {
        return searchHelper(0, new boolean[n][n]);
    }

    private int searchHelper(int row, boolean[][] board){
        int n = board.length;
        if(row == n) return 1;

        int count = 0;
        for(int i=0; i<n; i++){
            if(isValid(board, row, i)){
                board[row][i] = true;
                count += searchHelper(row + 1, board);
                board[row][i] = false;
            }
        }

        return count;
    }

    private boolean isValid(boolean[][] board, int i, int j){
        // column
        for(int k=0; k<i; k++){
            if(board[k][j]) return false;
        }
        // pos-diag
        for(int m=i-1, n=j-1; m>=0 && n>=0; m--, n--){
            if(board[m][n]) return false;
        }
        // neg-diag
        for(int m=i-1, n=j+1; m>=0 && n<board.length; m--, n++){
            if(board[m][n]) return false;
        }

        return true;
    }
}
