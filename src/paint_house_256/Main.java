package paint_house_256;

import java.util.Arrays;

/*
    There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

    For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
    Return the minimum cost to paint all houses.
 */
public class Main {
    public int minCost(int[][] costs) {
        int length = costs.length;
        int[] cache = new int[3];
        System.arraycopy(costs[0], 0, cache, 0, 3);

        for(int i=1; i<length; i++){
            int[] newCache = new int[3];
            for(int j=0; j<3; j++){
                newCache[j] = costs[i][j] + Math.min(cache[(j+1)%3], cache[(j+2)%3]);
            }
            cache = newCache;
        }

        return Math.min(cache[0], Math.min(cache[1], cache[2]));
    }
}
