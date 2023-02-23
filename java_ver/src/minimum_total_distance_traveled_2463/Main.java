package minimum_total_distance_traveled_2463;

import java.util.*;

public class Main {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(Comparator.naturalOrder());
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        for(int[] f: factory){
            f[1] = Math.min(f[1], 100);
        }
        /*
            3d dp

            Make robots and factories in order
            dp[i][j][k] = minimum distance for ith robot and jth factory, and the factory has k slots
         */
        return dfsHelper(robot, factory, 0, 0, 0, new long[robot.size()][factory.length][101]);
    }

    private long dfsHelper(List<Integer> robot, int[][] factory, int i, int j, int k, long[][][] cache){
        if(i == robot.size()) return 0;
        if(cache[i][j][k] != 0) return cache[i][j][k];

        long min = Long.MAX_VALUE;

        if(j + 1 < factory.length){
            min = Math.min(min, dfsHelper(robot, factory, i, j + 1, 0, cache));
        }
        if(k < factory[j][1]){
            long cost = dfsHelper(robot, factory, i + 1, j, k + 1, cache);
            if(cost != Long.MAX_VALUE){
                min = Math.min(min, cost + Math.abs(robot.get(i) - factory[j][0]));
            }
        }

        return cache[i][j][k] = min;
    }
}