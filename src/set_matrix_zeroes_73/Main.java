package set_matrix_zeroes_73;

import java.util.HashSet;
import java.util.Set;

/*
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

    You must do it in place.
 */
public class Main {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;

        // Record top line and left line
        boolean topFlag = false, leftFlag = false;
        for(int temp: matrix[0]){
            if(temp == 0){
                topFlag = true;
                break;
            }
        }

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                leftFlag = true;
                break;
            }
        }

        // Mark lines on leading number
        for(int i=1; i<height; i++){
            for(int j=1; j<width; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Fill
        for(int i=1; i<height; i++) {
            boolean rowFlag = matrix[i][0] == 0;
            for(int j = 1; j < width; j++) {
                if(rowFlag || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(topFlag){
            for(int j=0; j<width; j++){
                matrix[0][j] = 0;
            }
        }

        if(leftFlag){
            for(int i=0; i<height; i++){
                matrix[i][0] = 0;
            }
        }
    }

    /*public void setZeroes(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for(int i=0; i<height; i++){
            boolean rowFlag = rowSet.contains(i);
            for(int j=0; j<width; j++){
                if(rowFlag || columnSet.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }*/
}
