package number_of_ways_of_cutting_a_pizza_1444;

import java.util.Arrays;

/*
    Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts.
    For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.
    Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number, return this modulo 10^9 + 7.
 */
public class Main {
    public int ways(String[] pizza, int k) {
        /*
            Use a matrix int[][] to save count of cells with apple in the rectangle from (i, j) to (height, width)
         */
        int height = pizza.length, width = pizza[1].length();
        int[][] preSum = new int[height + 1][width + 1];
        for(int i=height - 1; i >= 0; i--){
            for(int j=width - 1; j >= 0; j--){
                preSum[i][j] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i + 1][j + 1]
                        + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }

        return dfsHelper(preSum, 0, 0, height, width, k - 1, new int[height][width][k]);
    }

    /*
        Helper function to find the count using DFS with DP
     */
    private int dfsHelper(int[][] preSum, int row, int col, int height, int width, int k, int[][][] cache){
        // No apple available in current area
        if(preSum[row][col] == 0) return 0;
        // Completed a way
        if(k == 0) return 1;

        // Visited
        if(cache[row][col][k] != 0) return cache[row][col][k];

        int count = 0;
        // Cut horizontally
        for(int i = row + 1; i < height; i++){
            // Check if the cutting part contains an apple
            if(preSum[row][col] - preSum[i][col] > 0)
                count = (count + dfsHelper(preSum, i, col, height, width, k - 1, cache)) % 1_000_000_007;
        }

        // Cut vertically
        for(int j = col + 1; j < width; j++){
            // Check if the cutting part contains an apple
            if(preSum[row][col] - preSum[row][j] > 0)
                count = (count + dfsHelper(preSum, row, j, height, width, k - 1, cache)) % 1_000_000_007;
        }

        cache[row][col][k] = count;
        return count;
    }
}
