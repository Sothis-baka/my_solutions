package random_pick_index_398;

import java.util.*;

/*
    Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
    Implement the Solution class:
    Solution(int[] nums) Initializes the object with the array nums.
    int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should have an equal probability of returning.
*/
public class Solution {
    Map<Integer, List<Integer>> cache;
    Random roll;

    public Solution(int[] nums) {
        this.cache = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            this.cache.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }

        roll = new Random();
    }

    public int pick(int target) {
        List<Integer> list = cache.get(target);
        return list.get(roll.nextInt(list.size()));
    }
}
