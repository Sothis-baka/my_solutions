package container_with_most_water_11;

import java.util.regex.Matcher;

/*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 */
public class Main {
    public static void main(String[] args){
        int[] temp = {2,3,4,5,18,17,6};
        System.out.println(maxArea(temp));
    }

    public static int maxArea(int[] height) {
        int max = 0;

        int left=0, right=height.length-1, lHeight, rHeight;

        while (left < right){
            lHeight = height[left];
            rHeight = height[right];
            max = Math.max(max,Math.min(height[left], rHeight) * ((right - left)));

            if(lHeight > rHeight){
                right--;
            }else {
                left++;
            }
        }

        return max;
    }
}
