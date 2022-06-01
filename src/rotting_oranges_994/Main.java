package rotting_oranges_994;

import java.util.ArrayList;
import java.util.List;

/*
    You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/
public class Main {
    // Movement directions
    static int[][] directions = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };

    public int orangesRotting(int[][] grid) {
        // BFS

        // Height and width
        int height = grid.length, width = grid[0].length;
        // List to save current cells
        List<int[]> cur = new ArrayList<>();
        // Count for fresh oranges
        int count = 0;

        // Iterate the matrix to find the initial state of rotten/fresh oranges
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                // 0 => nothing, 1 => fresh, 2 => rotten
                if(grid[i][j] == 1){
                    count++;
                }else if(grid[i][j] == 2){
                    cur.add(new int[]{i, j});
                }
            }
        }

        if(cur.isEmpty()) {
            if(count == 0) return 0;
            else return -1;
        }

        // BFS
        // Count for result;
        int result = -1;
        while(!cur.isEmpty()){
            result++;
            List<int[]> next = new ArrayList<>();
            for(int[] cell: cur){
                for(int[] dir: directions){
                    int i = cell[0] + dir[0];
                    int j = cell[1] + dir[1];

                    // Out of range
                    if(i < 0 || i >= height || j < 0 || j >= width){
                        continue;
                    }

                    // Shouldn't move there
                    if(grid[i][j] == 0 || grid[i][j] == 2){
                        continue;
                    }

                    // Set to rotten, so it won't be visit again
                    grid[i][j] = 2;
                    // Update count
                    count--;
                    // Save to next candidates list
                    next.add(new int[]{i, j});
                }

                // Replace list
                cur = next;
            }
        }

        // There are fresh oranges remain
        if(count != 0) return -1;

        return result;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println(new Main().orangesRotting(matrix));
    }
}
