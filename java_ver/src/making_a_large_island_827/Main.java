package making_a_large_island_827;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
    Return the size of the largest island in grid after applying this operation.
    An island is a 4-directionally connected group of 1s.
 */
public class Main {
    public int largestIsland(int[][] grid) {
        /*
            Use union find, find out which group a cell belongs to.
            If we turn grid[i][j] from 0 to 1
            The largest island is sum(sibling(grid[i][j]))
         */
        int height = grid.length, width = grid[0].length;
        UnionFind uf = new UnionFind(height, width);
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j] == 1) uf.add(i, j);
            }
        }

        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++) {
                if(grid[i][j] == 0) max = Math.max(max, uf.imagineAdd(i, j));
            }
        }

        return max == 0 ? height * width : max;
    }

    static int[][] dirs = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static int IMPOSSIBLE = -100000000;

    static class UnionFind{
        int[] prev;
        int height,  width;

        UnionFind(int height, int width){
            this.prev = new int[height * width];
            /*
                Default value MIN, not an island
                value > 0: root, value == count
                value < 0: value = its parent's index
             */
            Arrays.fill(prev, IMPOSSIBLE);
            this.height = height;
            this.width = width;
        }

        void add(int i, int j){
            // System.out.printf("%d, %d\n", i, j);
            Set<Integer> parents = tryAdd(i, j);
            int curIndex = getIndex(i, j);
            int total = 0;
            /*
                Point all of them to the new set
             */
            for(int index: parents){
                total += prev[index];
                prev[index] = -curIndex;
            }
            prev[curIndex] = total + 1;
            // print();
        }

        int imagineAdd(int i, int j){
            Set<Integer> parents = tryAdd(i, j);
            int count = 0;
            for(int index: parents) count += prev[index];
            return count + 1;
        }

        Set<Integer> tryAdd(int i, int j){
            Set<Integer> parents = new HashSet<>();
            /* find sibling sets */
            for(int[] dir: dirs){
                int newI = i + dir[0], newJ = j + dir[1];
                if(newI < 0 || newI >= height || newJ < 0 || newJ >= width) continue;

                int root = findRoot(getIndex(newI, newJ));
                if(root != IMPOSSIBLE) parents.add(root);
            }
            return parents;
        }

        int findRoot(int index){
            if(prev[index] > 0) return index;
            if(prev[index] == IMPOSSIBLE) return IMPOSSIBLE;
            prev[index] = -findRoot(-prev[index]);
            return -prev[index];
        }

        int getIndex(int i, int j)  {
            return i * width + j;
        }

        void print(){
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    System.out.print(prev[getIndex(i, j)] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        /*int[][] input = {
                {0,0,0,0,0,0,0},
                {0,1,1,1,1,0,0},
                {0,1,0,0,1,0,0},
                {1,0,1,0,1,0,0},
                {0,1,0,0,1,0,0},
                {0,1,0,0,1,0,0},
                {0,1,1,1,1,0,0}};*/
        int[][] input = {{1, 0}, {0, 1}};
        new Main().largestIsland(input);
    }
}
