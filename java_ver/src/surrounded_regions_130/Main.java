package surrounded_regions_130;

/*
    Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
    A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class Main {
    public static void solve(char[][] board) {
        int xMax = board.length;
        int yMax = board[0].length ;
        // Use to save examined non-closed cells
        int[][] mirror = new int[xMax][yMax];

        for (int i=0; i<xMax; i++){
            for (int j=0; j<yMax; j++){
                // Mark all O with number 1
                if(board[i][j] == 'O' && mirror[i][j] == 0)
                        mirror[i][j] = 1;

                // Only check cells at border
                if(i == 0 || j == 0 || i == xMax-1 || j == yMax-1) {
                    // Skip those checked cells
                    if (mirror[i][j] == 1)
                        checkOpen(board, i, j, mirror);
                }
            }
        }

        /*
            At this time, all closed O are marked with 1, replace them with X on board
         */
        for (int i=0; i<xMax; i++){
            for (int j=0; j<yMax; j++){
                if(mirror[i][j] == 1){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void checkOpen(char[][] board, int x, int y, int[][] mirror){
        // Out of bound
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length){
            return;
        }

        // Closed, stop checking
        if(board[x][y] == 'X'){
            return;
        }

        // Examined
        if(mirror[x][y] == 2){
            return;
        }

        // Mark all open O with number 2
        if(board[x][y] == 'O'){
            mirror[x][y] = 2;
        }

        // Recursively check all sibling cells
        checkOpen(board, x-1, y, mirror);
        checkOpen(board, x+1, y, mirror);
        checkOpen(board, x, y-1, mirror);
        checkOpen(board, x, y+1, mirror);
    }

    /* Helper function to visualize the matrix */
    public static void printMtx(char[][] board){
        for (char[] temp: board){
            for(char temp1: temp){
                System.out.print(temp1);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        char [][] board = {{'X'}};
        printMtx(board);
        solve(board);
        printMtx(board);
    }
}
