package equal_row_and_column_pairs_2352;

import java.util.HashMap;
import java.util.Map;

/*
    Given a 0-indexed n x n integer matrix grid, return the number of pairs (Ri, Cj) such that row Ri and column Cj are equal.
    A row and column pair is considered equal if they contain the same elements in the same order (i.e. an equal array).
 */
public class Main {
    static class Line{
        int value;
        Map<Integer, Line> map;
        int countR, countC;

        Line(){
            this.map = new HashMap<>();
        }

        Line(int value){
            this.value = value;
            this.map = new HashMap<>();
        }
    }

    public int equalPairs(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        int total = 0;

        Line start = new Line();
        for (int[] row : grid) {
            int j = 0;
            Line pt = start;
            while (j < width) {
                int val = row[j];
                if (pt.map.containsKey(val)) {
                    pt = pt.map.get(val);
                } else {
                    Line next = new Line(val);
                    pt.map.put(val, next);
                    pt = next;
                }

                if (j == width - 1) {
                    pt.countR++;
                }

                j++;
            }
        }

        for(int j=0; j<width; j++){
            int i = 0;
            Line pt = start;
            while (i < height){
                int val = grid[i][j];
                if(pt.map.containsKey(val)){
                    pt = pt.map.get(val);
                }else{
                    Line next = new Line(val);
                    pt.map.put(val, next);
                    pt = next;
                }

                if(i == height - 1) {
                    pt.countC++;
                    if(pt.countR > 0){
                        total += pt.countR;
                    }
                }

                i++;
            }
        }

        return total;
    }
}
