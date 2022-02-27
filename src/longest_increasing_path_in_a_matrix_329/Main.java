package longest_increasing_path_in_a_matrix_329;

/*
    Given an m x n integers matrix, return the length of the longest increasing path in matrix.
    From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 */
public class Main {
    public int longestIncreasingPath(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;

        int[][] cache = new int[height][width];

        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                max = Math.max(max, findPath(matrix, cache, i, j));
            }
        }

        return max;
    }

    private int findPath(int[][] matrix, int[][] cache, int i, int j){
        if(cache[i][j] != 0){
            return cache[i][j];
        }

        int cur = matrix[i][j], max = 0;
        if(i != 0 && matrix[i-1][j] < cur){
            max = Math.max(max, findPath(matrix, cache, i-1, j));
        }
        if(j != 0 && matrix[i][j-1] < cur){
            max = Math.max(max, findPath(matrix, cache, i, j-1));
        }
        if(i != matrix.length-1 && matrix[i+1][j] < cur){
            max = Math.max(max, findPath(matrix, cache, i+1, j));
        }
        if(j != matrix[0].length-1 && matrix[i][j+1] < cur){
            max = Math.max(max, findPath(matrix, cache, i, j+1));
        }

        cache[i][j] = max + 1;
        return cache[i][j];
    }
}
