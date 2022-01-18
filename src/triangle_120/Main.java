package triangle_120;

import java.util.List;

/*
    Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Main {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.get(triangle.size()-1).size();
        int[][] cache = new int[length][length];

        int min = Integer.MAX_VALUE;

        for(int i=0; i<length; i++){
            for(int j=0; j<=i; j++){
                if(i == 0){
                    cache[i][j] = triangle.get(i).get(j);
                }else if(j == 0){
                    cache[i][j] = triangle.get(i).get(j) + cache[i-1][j];
                }else if(j == i){
                    cache[i][j] = triangle.get(i).get(j) + cache[i-1][j-1];
                }else{
                    cache[i][j] = triangle.get(i).get(j) + Math.min(cache[i-1][j], cache[i-1][j-1]);
                }

                if(i == length - 1){
                    min = Math.min(min, cache[i][j]);
                }
            }
        }

        return min;
    }
}
