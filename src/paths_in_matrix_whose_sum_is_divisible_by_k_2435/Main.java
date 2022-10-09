package paths_in_matrix_whose_sum_is_divisible_by_k_2435;

import java.util.Arrays;

/*
        You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.
        Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.
    */
public class Main {
        public int numberOfPaths(int[][] grid, int k) {
            int height = grid.length, width = grid[0].length;

            int[][][] cache = new int[k][height][width];
            for(int[][] matrix: cache){
                for(int[] row: matrix)
                    Arrays.fill(row, -1);
            }

            return dfsCount(grid, 0, 0, height, width, 0, k, cache);
        }

        private int dfsCount(int[][] grid, int i, int j, int height, int width, int mod, int k, int[][][] cache){
            mod += grid[i][j];
            mod %= k;

            // Finished
            if(i == height - 1 && j == width - 1) {
                // valid
                if(mod == 0) return 1;
                return 0;
            }

            // Visited
            if(cache[mod][i][j] != -1)
                return cache[mod][i][j];

            int count = 0;
            // Go down
            if(i < height - 1)
                count = (count + dfsCount(grid, i + 1, j, height, width, mod, k, cache))
                        % 1_000_000_007;
            // Go right
            if(j < width - 1)
                count = (count + dfsCount(grid, i, j + 1, height, width, mod, k, cache))
                        % 1_000_000_007;

            return cache[mod][i][j] = count;
        }
}
