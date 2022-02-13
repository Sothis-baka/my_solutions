package longest_increasing_subsequence_300;

import java.util.Arrays;

/*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */
public class Main {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] cache = new int[length];
        int globalMax = 0;
        for(int i=0; i<length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    max = Math.max(max, cache[j]);
                }
            }
            cache[i] = max + 1;
            globalMax = Math.max(globalMax, cache[i]);
        }

        return globalMax;
    }
}
