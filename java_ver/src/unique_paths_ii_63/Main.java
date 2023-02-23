package unique_paths_ii_63;

/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    Now consider if some obstacles are added to the grids. How many unique paths would there be?
    An obstacle and space is marked as 1 and 0 respectively in the grid.
 */
public class Main {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length, width = obstacleGrid[0].length;
        int[][] cache = new int[height][width];

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(obstacleGrid[i][j] == 1){
                    // Obstacle
                    cache[i][j] = 0;
                }else if(i==0 && j==0){
                    // Top left
                    cache[i][j] = 1;
                }else{
                    // Cumulative
                    cache[i][j] = (i==0 ? 0 : cache[i-1][j]) + (j==0 ? 0 : cache[i][j-1]);
                }
            }
        }

        return cache[height-1][width-1];
    }
}
