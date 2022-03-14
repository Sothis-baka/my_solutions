package island_perimeter_463;

/*
    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 */
public class Main {
    public static int islandPerimeter(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        boolean[][] visited = new boolean[height][width];

        int result = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j] == 1) result += visit(grid, visited, i, j);
            }
        }

        return result;
    }

    private static int visit(int[][] grid, boolean[][] visited, int i, int j){
        if(i == grid.length || j == grid[0].length){
            return 1;
        }

        if(visited[i][j]){
            return 0;
        }

        visited[i][j] = true;
        int result = 0;
        if(grid[i][j] == 0){
            if(i != 0 && grid[i-1][j] == 1) result++;
            if(j != 0 && grid[i][j-1] == 1) result++;
        }else{
            if(i == 0 || grid[i-1][j] == 0) result++;
            if(j == 0 || grid[i][j-1] == 0) result++;
            result += visit(grid, visited, i + 1, j);
            result += visit(grid, visited, i, j + 1);
        }
        return result;
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
