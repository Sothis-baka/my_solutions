package dungeon_game_174;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length, width = dungeon[0].length;
        /*
            cache[][]: The minimum health point to reach the end point from each point
            0 if it's a positive number, since it won't affect the prev path
         */
        int[][] cache = new int[height][width];
        for(int i = height-1; i >= 0; i--){
            for(int j=width - 1; j>=0; j--){
                int max = Integer.MIN_VALUE;
                if(i < height - 1) max = Math.max(max, cache[i+1][j]);
                if(j < width - 1) max = Math.max(max, cache[i][j+1]);
                if(max == Integer.MIN_VALUE) max = 0;
                cache[i][j] = Math.min(0, max + dungeon[i][j]);
            }
        }

        return Math.abs(cache[0][0]) + 1;
    }
}
