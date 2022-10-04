package longest_subsequence_with_limited_sum_2389;

import java.util.Arrays;

/*
    You are given an integer array nums of length n, and an integer array queries of length m.

    Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].

    A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 */
public class Main {
    public int[] answerQueries(int[] nums, int[] queries) {
        int length = nums.length, resultL = queries.length;;
        int[] result = new int[resultL];

        // Sort the array
        Arrays.sort(nums);
        // Save the prefix sum
        for(int i=1; i<length; i++){
            nums[i] += nums[i - 1];
        }

        // At this moment, for every i in nums,
        // it means at most i+1 numbers can be less than or equals to nums[i]

        // Use binary search to find each corresponding count for the queries
        for(int i=0; i<resultL; i++){
            result[i] = Math.abs(Arrays.binarySearch(nums, queries[i]) + 1);
        }

        return result;
    }
}
