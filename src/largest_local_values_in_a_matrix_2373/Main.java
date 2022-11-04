package largest_local_values_in_a_matrix_2373;

/*
    You are given an n x n integer matrix grid.

    Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

    maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
    In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

    Return the generated matrix.
 */
public class Main {
    static int[][] dirs = { {-1,-1}, {0,-1}, {1, -1}, {-1, 0}, {0, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1} };

    public int[][] largestLocal(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int[][] result = new int[height - 2][width - 2];

        for(int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                helper(grid, result, i, j);
            }
        }

        return result;
    }

    private void helper(int[][] grid, int[][] result, int i, int j){
        for(int[] dir: dirs){
            int row = i + dir[0], col = j + dir[1];

            if(row  <= 0 || col <= 0 || row  >= grid.length - 1 || col >= grid[0].length - 1){
                continue;
            }

            result[row - 1][col - 1] = Math.max(result[row - 1][col - 1], grid[i][j]);
        }
    }
}
