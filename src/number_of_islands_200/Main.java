package number_of_islands_200;

/*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class Main {
    public int numIslands(char[][] grid) {
        int height = grid.length, width = grid[0].length;
        boolean[][] cache = new boolean[height][width];

        int count = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(!cache[i][j] && grid[i][j] == '1'){
                   mark(grid, cache, i, j);
                   count++;
                }
            }
        }

        return count;
    }

    private void mark(char[][] grid, boolean[][] cache, int x, int y){
        cache[x][y] = true;

        if(x > 0 && !cache[x-1][y] && grid[x-1][y] == '1')
            mark(grid, cache, x-1, y);

        if(x < grid.length - 1 && !cache[x+1][y] && grid[x+1][y] == '1')
            mark(grid, cache, x+1, y);

        if(y > 0 && !cache[x][y-1] && grid[x][y-1] == '1')
            mark(grid, cache, x, y-1);


        if(y < grid[0].length - 1 && !cache[x][y+1] && grid[x][y+1] == '1')
            mark(grid, cache, x, y+1);
    }

    public static void main(String[] args){

    }
}
