package merge_intervals_56;

import java.util.*;

/*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class Main {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // Unknown result length, using a LinkedList for fast edit on tail
        LinkedList<int[]> result = new LinkedList<>();
        for(int[] interval: intervals){
            if(result.isEmpty()) result.offer(interval);
            else{
                if(interval[0] > result.peekLast()[1]) result.offer(interval);
                // Overlap, use the larger range, which means start from a[0], end at max(a[1], b[1])
                else result.peekLast()[1] = Math.max(result.peekLast()[1], interval[1]);
            }
        }

        int[][] answer = new int[result.size()][2];
        int i = 0;
        for(int[] interval: result){
            answer[i++] = interval;
        }
        return answer;
    }
}
