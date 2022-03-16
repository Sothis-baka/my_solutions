package the_maze_490;

import java.util.LinkedList;
import java.util.Queue;

/*
    There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won’t stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
    Given the ball’s start position, the destination and the maze, determine whether the ball could stop at the destination.
    The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 */
public class Main {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Status{
        int i, j;
        int dir;

        Status(int i, int j, int dir){
            this.i = i;
            this.j = j;
            this.dir = dir;
        }

        @Override
        public String toString(){
            return "i: " + i + ", j: " + j + ", dir: " + dir;
        }
    }

    public static boolean hasPath(int[][] board, int[] start, int[] end){
        int height = board.length, width = board[0].length;

        Queue<Status> candidates = new LinkedList<>();
        boolean[][][] cache = new boolean[height][width][4];
        for(int i=0; i<4; i++) candidates.offer(new Status(start[0], start[1], i));

        while(!candidates.isEmpty()){
            Status status = candidates.poll();
            int i = status.i, j = status.j, dir = status.dir;
            if(i == end[0] && j == end[1]) return true;

            if(i < 0 || i >= height || j < 0 || j >= width || board[i][j] == 1){
                int lastI = i - dirs[dir][0], lastJ = j - dirs[dir][1];
                for(int d=0; d<4; d++) {
                    if(d != dir) candidates.offer(new Status(lastI, lastJ, d));
                }
            }else{
                if(cache[i][j][dir]) continue;
                cache[i][j][dir] = true;
                candidates.offer(new Status(i + dirs[dir][0], j + dirs[dir][1], dir));
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] board = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0, 4};
        int[] end = {4, 4};
        System.out.println(hasPath(board, start, end));
    }
}
