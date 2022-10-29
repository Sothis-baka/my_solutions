package temp;

import java.util.*;

public class Main {
    // there are four nodes in example graph (graph is
    // 1-based)

    static int n = 14;
    // give appropriate maximum to avoid overflow

    static int MAX = 1000000;

    // dist[i][j] represents shortest distance to go from i
    // to j this matrix can be calculated for any given
    // graph using all-pair shortest path algorithms
    static int[][] dist = {
            {0, 0, 0, -1, 54, 0, 51, 102, 80, 52, 0, 68, 51, 44, 100},
            {0, 0, 56, 102, 63, 70, 0, 0, 0, 93, -6, 48, 0, 0, 0},
            {84, -9, 0, 83, 0, 73, 20, 38, 0, -8, 105, 0, 43, 73, 2},
            {0, 0, 36, 0, 54, 24, 0, 59, 0, 83, 40, 75, 15, 74, 0},
            {14, 30, 87, 96, 0, 48, 84, 0, 0, 14, 0, 75, 0, 49, 0},
            {0, 103, 62, 0, 88, 0, 84, 11, 79, 27, 2, 102, 61, 16, 1},
            {0, 0, 33, 0, 79, 86, 0, 26, 1, 2, 12, 74, 0, 84, 50},
            {0, 1, 0, 68, 86, 19, 0, 0, 100, 12, 95, 25, 55, -2, 97},
            {100, 76, 0, 59, 0, 69, 47, 72, 0, 76, 19, 47, 91, 94, 11},
            {21, 48, 0, 30, 74, 2, -1, 0, 104, 0, 33, 22, 38, 68, 95},
            {0, 79, 15, 0, 28, 100, 91, 103, 0, 9, 0, 76, 41, 0, 102},
            {39, 83, 0, 49, 0, 101, 40, 0, 0, 55, 82, 0, 0, 0, 0},
            {101, 71, -2, 26, 109, 0, 82, 33, 7, 0, -1, -5, 0, 19, 11},
            {62, 98, 27, 39, 78, 0, 106, 0, 64, 24, 0, 58, 29, 0, 49},
            {10, 18, 26, 62, 6, 90, 75, 0, 0, 24, 46, 0, -7, 41, 0}
    };

    // memoization for top down recursion

    static int[][] memo = new int[n + 1][1 << (n + 1)];

    static int fun(int i, int mask)
    {
        // base case
        // if only ith bit and 1st bit is set in our mask,
        // it implies we have visited all other nodes
        // already
        if (mask == ((1 << i) | 3))
            return dist[1][i];
        // memoization
        if (memo[i][mask] != 0)
            return memo[i][mask];

        int res = MAX; // result of this sub-problem

        // we have to travel all nodes j in mask and end the
        // path at ith node so for every node j in mask,
        // recursively calculate cost of travelling all
        // nodes in mask
        // except i and then travel back from node j to node
        // i taking the shortest path take the minimum of
        // all possible j nodes

        for (int j = 1; j <= n; j++)
            if ((mask & (1 << j)) != 0 && j != i && j != 1){
                if(dist[i][j] != 0)
                    res = Math.min(res,
                            fun(j, mask & (~(1 << i)))
                                    + dist[i][j]);
            }

        return memo[i][mask] = res;
    }

    // Driver program to test above logic
    public static void main(String[] args)
    {
        int ans = MAX;
        /*for (int i = 1; i <= n; i++)
            // try to go from node 1 visiting all nodes in
            // between to i then return from i taking the
            // shortest route to 1
            ans = Math.min(ans, fun(i, (1 << (n + 1)) - 1)
                    + dist[i][1]);*/

        System.out.println(
                "The cost of most efficient tour = " + fun(2, (1 << (n + 1)) - 1));
    }
}