package non_decreasing_array_665;

/*
    Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
    We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 */

import java.util.Stack;

public class Main {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        boolean find = false;

        for(int i=1; i<length; i++){
            if(nums[i] < nums[i-1]){
                if(find) return false;

                if(nums[i - 2] <= nums[i]){
                    nums[i - 1] = nums[i];
                }else{
                    nums[i] = nums[i - 1];
                }

                find = true;
            }
        }

        return true;
    }
}
