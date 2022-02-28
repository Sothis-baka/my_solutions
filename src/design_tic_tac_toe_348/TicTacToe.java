package design_tic_tac_toe_348;

/*
    Design a Tic-tac-toe game that is played between two players on a n x n grid.

    You may assume the following rules:

    A move is guaranteed to be valid and is placed on an empty block.
    Once a winning condition is reached, no more moves is allowed.
    A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
*/
public class TicTacToe {
    int[][] board;

    TicTacToe(int n){
        this.board = new int[n][n];
    }

    int move(int i, int j, int player){
        if(!isValid(i, j)){
            return -1;
        }

        board[i][j] = player;

        if(win(i, j, player)){
            return player;
        }

        return 0;
    }

    boolean isValid(int i, int j){
        return board[i][j] == 0;
    }

    boolean win(int i, int j, int player){
        int length = this.board.length;

        boolean findIt = true;
        for(int k=0; k<length; k++){
            if(board[i][k] != player){
                findIt = false;
                break;
            }
        }
        if(findIt){
            return true;
        }

        findIt = true;
        for (int[] ints : this.board) {
            if (ints[j] != player) {
                findIt = false;
                break;
            }
        }
        if(findIt){
            return true;
        }

        if(i == j || length - 1 - i == j){
            for(int k=0; k<length; k++){
                if(board[k][k] != player){
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public static void main(String[] args){
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }
}
