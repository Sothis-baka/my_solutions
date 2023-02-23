package three_sum_closest_16;

import java.util.Arrays;

/*
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
    Return the sum of the three integers.
    You may assume that each input would have exactly one solution.
 */
public class Main {
    public static void main(String[] args){
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        // in case when it adds a number causing exceed integer bound
        int min = Integer.MAX_VALUE - 1001;

        for(int i=0; i<nums.length-2; i++){
            int sum = findThreeMin(nums, i, target);

            if(sum == target){
                return target;
            }

            if(Math.abs(sum - target) < Math.abs(min - target)){
                min = sum;
            }
        }

        return min;
    }

    public static int findThreeMin(int[] nums, int index, int target){
        int min = Integer.MAX_VALUE - 1001;

        int start = index + 1;
        int end = nums.length-1;
        int curVal = nums[index];

        while(start < end){
            int sum = curVal + nums[start] + nums[end];

            if(Math.abs(sum - target) < Math.abs(min-target)){
                min = sum;
            }

            if(sum == target){
                return sum;
            }else if(sum < target){
                start++;
            }else {
                end--;
            }
        }

        return min;
    }
}
