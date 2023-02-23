package the_maze_ii_505;

import java.util.Map;

/*
    There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
    Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
    The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 */
public class Main {
    public static int shortestDistance(int[][] maze, int[] start, int[] destination){
        int height = maze.length, width = maze[0].length;
        int[][] cache = new int[height][width];
        boolean[][] visiting = new boolean[height][width];

        return mazeHelper(maze, start[0], start[1], destination, cache, visiting);
    }

    private static int mazeHelper(int[][] maze, int i, int j, int[] destination, int[][] cache, boolean[][] visiting){
        if(cache[i][j] != 0) return cache[i][j];
        if(visiting[i][j]) return -1;
        if(i == destination[0] && j == destination[1]) return 0;

        visiting[i][j] = true;
        int min = Integer.MAX_VALUE;
        int copy = i;
        while(copy > 0 && maze[copy-1][j] == 0) copy--;
        if(copy != i){
            int result = mazeHelper(maze, copy, j, destination, cache, visiting);
            if(result >= 0) min = result + (i - copy);
        }
        copy = i;
        while(copy < maze.length - 1 && maze[copy+1][j] == 0) copy++;
        if(copy != i){
            int result = mazeHelper(maze, copy, j, destination, cache, visiting);
            if(result >= 0) min = Math.min(min, result + copy - i);
        }
        copy = j;
        while(copy > 0 && maze[i][copy-1] == 0) copy--;
        if(copy != j){
            int result = mazeHelper(maze, i, copy, destination, cache, visiting);
            if(result >= 0) min = Math.min(min, result + j - copy);
        }
        copy = j;
        while(copy < maze[0].length - 1 && maze[i][copy+1] == 0) copy++;
        if(copy != j){
            int result = mazeHelper(maze, i, copy, destination, cache, visiting);
            if(result >= 0) min = Math.min(min, result + copy - j);
        }

        visiting[i][j] = false;
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args){
        int[][] maze = new int[][]{{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] destination = new int[]{4,4};
        System.out.println(shortestDistance(maze, start, destination));
    }
}
