package valid_sudoku_36;

import java.util.HashSet;
import java.util.Set;

/*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class Main {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            Set<Character> temp = new HashSet<>();
            for(int j=0; j<9; j++){
                char ch = board[i][j];
                if(ch == '.'){
                    continue;
                }

                if(temp.contains(ch)){
                   return false;
                }else{
                    temp.add(ch);
                }
            }
        }

        for(int i=0; i<9; i++){
            Set<Character> temp = new HashSet<>();
            for(int j=0; j<9; j++){
                char ch = board[j][i];
                if(ch == '.'){
                    continue;
                }

                if(temp.contains(ch)){
                    return false;
                }else{
                    temp.add(ch);
                }
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                Set<Character> temp = new HashSet<>();
                for(int k=0; k<3; k++){
                    for (int l=0; l<3; l++){
                        char ch = board[i*3+k][j*3+l];
                        if(ch == '.'){
                            continue;
                        }

                        if(temp.contains(ch)){
                            return false;
                        }else{
                            temp.add(ch);
                        }
                    }
                }
            }
        }

        return true;
    }
}
