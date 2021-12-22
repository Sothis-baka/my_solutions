package trapping_rain_water_42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class Main {
    public static int trap(int[] height) {
        int total = 0, length = height.length;

        int curMax = 0;
        int[] left = new int[length], right = new int[length];

        // Fill from left
        for(int i=0; i<length; i++){
            if(curMax > height[i]){
                left[i] = curMax;
            }else{
                left[i] = height[i];
                curMax = height[i];
            }
        }


        curMax = 0;
        for(int i=length-1; i>=0; i--){
            if(curMax > height[i]){
                right[i] = curMax;
            }else{
                right[i] = height[i];
                curMax = height[i];
            }
        }

        for(int i=0; i<length; i++){
            total += Math.min(left[i], right[i]) - height[i];
        }

        return total;
    }

    public static void main(String[] args){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trap(new int[]{4,2,3}));
    }
}
