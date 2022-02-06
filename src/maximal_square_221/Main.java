package maximal_square_221;

/*
    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class Main {
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length + 1, width = matrix[0].length + 1;
        int[][] cache = new int[height+1][width+1];

        // Read from top left to bottom right
        int max = 0;
        for(int i=1; i<height; i++){
            for(int j=1; j<width; j++){
                if(matrix[i-1][j-1] == '1'){
                    cache[i][j] = Math.min(cache[i][j-1], Math.min(cache[i-1][j], cache[i-1][j-1])) + 1;
                    max = Math.max(max, cache[i][j]);
                }
            }
        }

        return max * max;
    }
}
