package trapping_rain_water_42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class Main {
    public static int trap(int[] height) {
        // Greedy search
        // Iterate from start to end to determine edge from front, and reversely to determine edge from end.
        int length = height.length;

        int[] left = new int[length];
        int[] right = new int[length];

        int max = 0;
        for(int i=0; i<length; i++){
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for(int i=length-1; i>=0; i--){
            right[i] = max;
            max = Math.max(max, height[i]);
        }

        int total = 0;
        for(int i=0; i<length; i++){
            total += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }

        return total;
    }

    public static void main(String[] args){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trap(new int[]{4,2,3}));
    }
}
