package the_skyline_problem_218;

import java.util.*;

/*
    A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

    The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

    lefti is the x coordinate of the left edge of the ith building.
    righti is the x coordinate of the right edge of the ith building.
    heighti is the height of the ith building.
    You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

    The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
*/
public class Main {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for(int[] building: buildings){
            // Left side marked with negative value
            height.add(new int[]{building[0], -building[2]});
            // Right side
            height.add(new int[]{building[1], building[2]});
        }

        height.sort((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];

            return a[1] - b[1];
        });

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b-a));
        queue.offer(0);
        int prev=0;

        for(int[] temp: height){
            if(temp[1] < 0){
                // Start rectangle
                queue.offer(-temp[1]);
            }else{
                // Finish rectangle
                queue.remove(temp[1]);
            }

            int cur = queue.peek();
            if(cur != prev){
                List<Integer> newList = new ArrayList<>();
                newList.add(temp[0]);
                newList.add(cur);
                result.add(newList);
                prev = cur;
            }
        }

        return result;
    }
}
