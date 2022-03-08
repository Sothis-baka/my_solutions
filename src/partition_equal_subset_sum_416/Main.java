package partition_equal_subset_sum_416;

import java.util.*;

/*
    Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 */
public class Main {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        // Not even
        if(sum % 2 != 0){
            return false;
        }

        boolean[][] cache = new boolean[nums.length][sum+1];
        return helper(nums, 0,  sum, sum / 2, cache);
    }

    private boolean helper(int[] nums, int index, int cur, int target, boolean[][] cache){
        if(cur == target){
            return true;
        }

        int length = nums.length;
        if(index == length || cache[index][cur]){
            return false;
        }

        for(int i=index; i<length; i++){
            if(helper(nums, i+1, cur - nums[i], target, cache)){
                return true;
            }
        }

        cache[index][cur] = true;
        return false;
    }
}
