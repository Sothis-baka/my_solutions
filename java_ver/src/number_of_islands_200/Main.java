package number_of_islands_200;

/*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class Main {
    // Iterate all cells. Mark connected cells and count as an island. Ignore visited cells.

    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int numIslands(char[][] grid) {
        int height = grid.length, width = grid[0].length;
        // Save visited positions.
        boolean[][] visited = new boolean[height][width];
        int count = 0;

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j] == '1' && !visited[i][j]) {
                    mark(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void mark(char[][] grid, boolean[][] visited, int i, int j){
        // Out of bound
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;

        // Visited
        if(visited[i][j]) return;

        // Water
        if(grid[i][j] == '0') return;

        // Mark and continue
        visited[i][j] = true;
        for(int[] dir: dirs){
            mark(grid, visited, i + dir[0], j+dir[1]);
        }
    }
}
