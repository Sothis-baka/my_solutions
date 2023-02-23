package search_a_2d_matrix_ii_240;

/*
    Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
 */
public class Main {
    public boolean searchMatrix(int[][] matrix, int target) {
        int jMax = matrix[0].length;

        for (int[] ints : matrix) {
            for (int j = 0; j < jMax; j++) {
                int val = ints[j];
                if (val == target) {
                    return true;
                } else if (val > target) {
                    jMax = j + 1;
                    break;
                }
            }
        }

        return false;
    }

    /*public boolean searchMatrix(int[][] matrix, int target) {
        boolean[][] cache = new boolean[matrix.length][matrix[0].length];
        return searchHelper(matrix, 0, 0, target, cache);
    }

    private boolean searchHelper(int[][] matrix, int i, int j, int target, boolean[][] cache){
        if(i >= matrix.length || j >= matrix[0].length || cache[i][j]){
            return false;
        }

        if(matrix[i][j] == target){
            return true;
        }else if(matrix[i][j] > target){
            return false;
        }else{
            boolean result =  searchHelper(matrix, i+1, j, target, cache) || searchHelper(matrix, i, j+1, target, cache);
            if(!result){
                // Mark
                cache[i][j] = true;
            }
            return result;
        }
    }*/
}
