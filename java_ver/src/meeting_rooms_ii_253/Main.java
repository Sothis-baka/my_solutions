package meeting_rooms_ii_253;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
    For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class Main {
    public int minMeetingRooms(int[][] intervals) {
        /*
            Sort the intervals by their start time
            If start time are the same, sort by end time
         */
        Arrays.sort(intervals,
                (a, b) -> a[0] == b[0]
                        ? a[1] - b[1]
                        : a[0] - b[0]
        );

        /*
            Save rooms in a Priority Queue, with meeting end time as their values
         */
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        /*
            Iterate all the intervals
            If there is a room available, poll it from queue, set new time, and offer back to the queue
            If there is no available room, create a new room and add to the queue
         */
        for(int[] interval: intervals){
            // Last meeting already ended
            if(!rooms.isEmpty() && interval[0] >= rooms.peek()){
                rooms.poll();
            }

            rooms.offer(interval[1]);
        }

        return rooms.size();
    }

    public static void main(String[] args){
        System.out.println(new Main().minMeetingRooms(new int[][]{{0,30}, {5,10}, {15,20}}));
    }
}
