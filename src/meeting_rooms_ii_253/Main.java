package meeting_rooms_ii_253;

import java.util.Arrays;

/*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
    For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class Main {
    public static int minMeetingRooms(int[][] intervals) {
        int count = 1;

        Arrays.sort(intervals, (a, b) -> b[0] - a[0]);

        int max = 0;
        for(int[] pair: intervals){
            if(pair[0] < max){
                count++;
            }
            max = Math.max(max, pair[1]);
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(minMeetingRooms(new int[][]{{0,30}, {5,10}, {15,20}}));
        System.out.println(minMeetingRooms(new int[][]{{0,30}, {15,20}, {21, 30}}));
        System.out.println(minMeetingRooms(new int[][]{{5,10}, {15,20}, {16,21}}));
    }
}
