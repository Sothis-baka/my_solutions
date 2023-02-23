package meeting_rooms_iii_2402;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    You are given an integer n. There are n rooms numbered from 0 to n - 1.
    You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.
    Meetings are allocated to rooms in the following manner:

    Each meeting will take place in the unused room with the lowest number.
    If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
    When a room becomes unused, meetings that have an earlier original start time should be given the room.
    Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.
    A half-closed interval [a, b) is the interval between a and b including a and not including b.
 */
public class Main {
    public int mostBooked(int n, int[][] meetings) {
        // Use int[]{index, ending time} to save rooms.
        PriorityQueue<long[]> availableRooms = new PriorityQueue<>(
                Comparator.comparingLong(a -> a[0]) // Sort by room index
        );
        PriorityQueue<long[]> usingRooms = new PriorityQueue<>(
                // Sort by ending time
                (a, b) ->
                        a[1] == b[1]
                                ? Long.compare(a[0], b[0])
                                : Long.compare(a[1], b[1])
        );
        // Use an array to save counts of rooms
        int[] counts = new int[n];
        // Sort the meetings
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        // Init the rooms
        for(int i=0; i<n; i++){
            availableRooms.offer(new long[]{i, 0});
        }

        for(int[] meeting: meetings){
            int startTime = meeting[0], endTime = meeting[1];

            // Release all meeting ends rooms
            while (!usingRooms.isEmpty() && startTime >= usingRooms.peek()[1]){
                availableRooms.offer(usingRooms.poll());
            }

            long[] room;
            if(availableRooms.isEmpty()){
                // No available room now
                // Jump to the 1st room's ending time
                room = usingRooms.poll();
                // Extend time by meeting duration
                room[1] += endTime - startTime; // number of total rooms is large than 0, so there must be at least a room here
            }else{
                // Use the 1st available room
                room = availableRooms.poll();
                room[1] = endTime;
            }

            usingRooms.offer(room);
            counts[(int) room[0]]++;
        }

        // Find the largest count
        int max = -1, index = -1;
        for(int i=0; i<n; i++){
            if(counts[i] > max){
                index = i;
                max = counts[i];
            }
        }

        return index;
    }

    public static void main(String[] args){
        System.out.println(
                new Main().mostBooked(4,
                        new int[][]{{48,49},{22,30},{13,31},{31,46},{37,46},{32,36},{25,36},{49,50},{24,34},{6,41}}
                        ));
    }
}
