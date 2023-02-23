package shortest_distance_from_all_buildings_317;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
    Each 0 marks an empty land which you can pass by freely.
    Each 1 marks a building which you cannot pass through.
    Each 2 marks an obstacle which you cannot pass through.
 */
public class Main {
    public static int shortestDistance(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int[][] distances = new int[height][width];

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j] == 1){
                    int[][] curDistances = bfsDistance(grid, i, j);
                    for(int m=0; m<height; m++){
                        for(int n=0; n<width; n++){
                            // Dead road
                            if(grid[m][n] == 0 && curDistances[m][n] == 0){
                                return -1;
                            }

                            // It's a house, count its distances to all the cells.
                            distances[m][n] += curDistances[m][n];
                        }
                    }
                }
            }
        }

        // Find the smallest one
        int min = Integer.MAX_VALUE;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j] == 0){
                    min = Math.min(min, distances[i][j]);
                }
            }
        }

        return min;
    }

    private static int[][] bfsDistance(int[][] grid, int i, int j){
        int height = grid.length, width = grid[0].length;
        int[][] distances = new int[height][width];

        Queue<int[]> candidates = new LinkedList<>();
        candidates.offer(new int[]{i, j});

        while(!candidates.isEmpty()){
            int[] cell = candidates.poll();
            int y = cell[0], x = cell[1];

            // Check all neighbors
            if(y != 0){
                if(grid[y - 1][x] == 0 && distances[y - 1][x] == 0){
                    distances[y - 1][x] = distances[y][x] + 1;
                    candidates.offer(new int[]{y - 1, x});
                }
            }

            if(y != height - 1){
                if(grid[y + 1][x] == 0 && distances[y + 1][x] == 0){
                    distances[y + 1][x] = distances[y][x] + 1;
                    candidates.offer(new int[]{y + 1, x});
                }
            }

            if(x != 0){
                if(grid[y][x - 1] == 0 && distances[y][x - 1] == 0){
                    distances[y][x - 1] = distances[y][x] + 1;
                    candidates.offer(new int[]{y, x - 1});
                }
            }

            if(x != width - 1){
                if(grid[y][x + 1] == 0 && distances[y][x + 1] == 0){
                    distances[y][x + 1] = distances[y][x] + 1;
                    candidates.offer(new int[]{y, x + 1});
                }
            }
        }

        return distances;
    }

    public static void main(String[] args){
        System.out.println(shortestDistance(new int[][]{{1,0,2,0,1}, {0,0,2,0,0}, {0,0,2,0,0}}));
    }
}
