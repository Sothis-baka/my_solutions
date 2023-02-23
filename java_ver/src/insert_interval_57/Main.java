package insert_interval_57;

import java.util.*;

/*
    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
    Return intervals after the insertion.
 */
public class Main {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals) result.add(interval);
        int i=0;
        while(i < result.size() && result.get(i)[0] < newInterval[0]) i++;
        result.add(i, newInterval);

        // First merge from left might change the index.
        merge(result, i, i+1);
        merge(result, i-1, i);

        int size = result.size();
        int[][] answer = new int[size][];
        for(i=0; i<size; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    private static void merge(List<int[]> intervals, int i, int j){
        if(i < 0 || j == intervals.size()) return;

        int l1 = intervals.get(i)[0], r1 = intervals.get(i)[1], l2 = intervals.get(j)[0], r2 = intervals.get(j)[1];

        // Not intersected
        if(r1 < l2) return;

        if(r1 >= r2) {
            // Included, do nothing
        }else{
            // Need to extend
            intervals.get(i)[1] = r2;
        }

        intervals.remove(j);
        merge(intervals, i, i+1);
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
