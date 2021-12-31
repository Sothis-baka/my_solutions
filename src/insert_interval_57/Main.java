package insert_interval_57;

import java.util.*;

/*
    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
    Return intervals after the insertion.
 */
public class Main {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        list.add(newInterval);
        list.addAll(Arrays.asList(intervals));

        list.sort((a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        for(int[] temp: list){
            if(result.isEmpty()){
                result.add(temp);
            }else{
                int[] prev = result.get(result.size() - 1);
                if(prev[1] < temp[0]){
                    result.add(temp);
                }else{
                    prev[1] = Math.max(prev[1], temp[1]);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args){
        int[][] intervals = new int[][]{{1,3},{5,7}};
        int[] input = new int[]{4,4};

        int[][] result = insert(intervals, input);
        for(int[] row: result){
            for(int temp: row){
                System.out.print(temp);
            }
            System.out.println();
        }
    }
}
