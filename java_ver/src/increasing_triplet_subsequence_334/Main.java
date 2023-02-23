package increasing_triplet_subsequence_334;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
    Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */
public class Main {
    public boolean increasingTriplet(int[] nums) {
        Integer[] cache = new Integer[2];

        for(int temp: nums){
            if(cache[0] == null){
                cache[0] = temp;
            }else if(temp <= cache[0]){
                cache[0] = temp;
            }else if(cache[1] == null){
                cache[1] = temp;
            }else if(temp <= cache[1]){
                cache[1] = temp;
            }else{
                return true;
            }
        }

        return false;
    }
}
