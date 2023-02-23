package unique_paths_62;

import java.math.BigInteger;

public class Main {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m+1][n+1];
        cache[1][0] = 1; /* Set a sibling of start point as 1, so that the start point will be 1 */

        /* DP, Calculate the number of paths from start point to each point */
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                cache[i][j] = cache[i][j-1] + cache[i-1][j];
            }
        }
        return cache[m][n];
    }
}
