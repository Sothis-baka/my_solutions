package sudoku_solver_37;

/*
    Write a program to solve a Sudoku puzzle by filling the empty cells.
 */
public class Main {
    public static void solveSudoku(char[][] board) {
        solvable(board);
    }

    /*
        Recursively find next empty cell, fill in a valid number, check if it's ok to fill the whole matrix.
     */
    public static boolean solvable(char[][] board) {
        for(int i=0; i<81; i++){
            int x = i % 9, y = i / 9;
            if(board[y][x] == '.'){
                for(int temp=1; temp<10; temp++){
                    char chNum = (char)(temp+'0');
                    if(choiceValid(board, x, y, chNum)){
                        board[y][x] = chNum;
                        if(solvable(board)){
                            return true;
                        }
                    }
                }

                board[y][x] = '.';
                return false;
            }
        }

        // All cells are filled
        return true;
    }

    public static boolean choiceValid(char[][] board, int x, int y, char val){
        // The row
        for(int i=0; i<9; i++){
            if(board[y][i] == val){
                return false;
            }
        }

        // The column
        for(int i=0; i<9; i++){
            if(board[i][x] == val){
                return false;
            }
        }

        // The 3*3 square
        int sqrX = x / 3 * 3;
        int sqrY = y / 3 * 3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if((x != sqrX || y != sqrY) && board[sqrY + i][sqrX + j] == val){
                    return false;
                }
            }
        }

        return true;
    }

    private static void printMatrix(char[][] board){
        for(int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        char[][] input = new char[][]{{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        printMatrix(input);
        solveSudoku(input);
        printMatrix(input);
    }
}
