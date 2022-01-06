package minimum_sum_path_64;

/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 */
public class Main {
    public int minPathSum(int[][] grid) {
        int height = grid.length, width = grid[0].length;

        int[][] cache = new int[height][width];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                cache[i][j] += grid[i][j];
                if(i==0){
                    if(j!=0){
                        cache[i][j] += cache[i][j-1];
                    }
                }else if(j==0){
                    cache[i][j] += cache[i-1][j];
                }else{
                    cache[i][j] += Math.min(cache[i][j-1], cache[i-1][j]);
                }
            }
        }

        return cache[height-1][width-1];
    }
}
