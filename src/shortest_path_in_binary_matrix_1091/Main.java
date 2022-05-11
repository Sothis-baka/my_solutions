package shortest_path_in_binary_matrix_1091;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int[][] dirs = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        // Can't start
        if(grid[0][0] == 1) return -1;
        // No need to start
        if(height == 1 && width == 1) return 1;

        // Save calculated cases
        int[][] cache = new int[height][width];

        List<int[]> candidates = new ArrayList<>();
        candidates.add(new int[]{0, 0});
        cache[0][0] = 1;
        int depth = 1;

        while(!candidates.isEmpty()){
            depth++;
            List<int[]> newCandidates = new ArrayList<>();
            for(int[] pos: candidates){
                for(int[] dir: dirs){
                    int newI = pos[0] + dir[0], newJ = pos[1] + dir[1];
                    if(newI >= 0 && newI < height && newJ >=0 && newJ < width && grid[newI][newJ] == 0 && cache[newI][newJ] == 0){
                        // Valid case
                        cache[newI][newJ] = depth;
                        newCandidates.add(new int[]{newI, newJ});
                    }
                }
            }

            // Next round
            candidates = newCandidates;
        }

        int result = cache[height-1][width-1];
        return result == 0 ? -1 : result;
    }
}
