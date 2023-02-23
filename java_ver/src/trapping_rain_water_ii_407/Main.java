package trapping_rain_water_ii_407;

import java.util.PriorityQueue;

/*
    Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.
 */
public class Main {
    public static int trapRainWater(int[][] heightMap) {
        int height = heightMap.length, width = heightMap[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        PriorityQueue<int[]> candidates = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[height][width];
        for(int i=0; i<height; i++){
            candidates.offer(new int[]{i, 0, heightMap[i][0]});
            candidates.offer(new int[]{i, width - 1, heightMap[i][width - 1]});
            visited[i][0] = true;
            visited[i][width - 1] = true;
        }
        for(int j=1; j<width - 1; j++){
            candidates.offer(new int[]{0, j, heightMap[0][j]});
            candidates.offer(new int[]{height - 1, j, heightMap[height - 1][j]});
            visited[0][j] = true;
            visited[height - 1][j] = true;
        }

        int result = 0;
        while(!candidates.isEmpty()){
            int[] cur = candidates.poll();

            for(int[] dir: dirs){
                int i = cur[0] + dir[0], j = cur[1] + dir[1];
                if(i < 0 || i >= height|| j < 0 || j >= width || visited[i][j]){
                    continue;
                }

                result += Math.max(0, cur[2] - heightMap[i][j]);
                visited[i][j] = true;
                candidates.offer(new int[]{i, j, Math.max(heightMap[i][j], cur[2])});
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] heightMap = new int[][]{{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        System.out.println(trapRainWater(heightMap));
    }
}
