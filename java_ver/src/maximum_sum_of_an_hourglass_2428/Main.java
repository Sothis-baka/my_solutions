package maximum_sum_of_an_hourglass_2428;

/*
    You are given an m x n integer matrix grid.
    We define an hourglass as a part of the matrix with the following form:
    Return the maximum sum of the elements of an hourglass.
    Note that an hourglass cannot be rotated and must be entirely contained within the matrix.
 */
public class Main {
    public int maxSum(int[][] grid) {
        /*
            Create a preSum to save all sum of squares from (0, 0) to (i, j)
         */
        int height = grid.length, width = grid[0].length;
        int[][] preSum = new int[height + 1][width + 1];

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                preSum[i + 1][j + 1] = preSum[i][j+1] + preSum[i+1][j] - preSum[i][j]
                        + grid[i][j];
            }
        }

        int max = 0;
        /*
            For all point with i >= 3 and j >= 3, count the hourglass sum by subtract from the square sum
         */
        for(int i=2; i<height; i++){
            for(int j=2; j<width; j++){
                int sum = preSum[i + 1][j + 1] + preSum[i - 2][j - 2]
                        - preSum[i + 1][j - 2] - preSum[i - 2][j + 1];
                // Subtract the empty cell;
                sum -= grid[i - 1][j - 2] + grid[i-1][j];

                // Update result
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
