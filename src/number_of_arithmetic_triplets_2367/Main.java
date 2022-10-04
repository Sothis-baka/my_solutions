package number_of_arithmetic_triplets_2367;

import java.util.HashSet;
import java.util.Set;

/*
    You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

    i < j < k,
    nums[j] - nums[i] == diff, and
    nums[k] - nums[j] == diff.
    Return the number of unique arithmetic triplets.
 */
public class Main {
    public int arithmeticTriplets(int[] nums, int diff) {
        // Using a set to store visited nums
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for(int num: nums){
            if(set.contains(num - diff) && set.contains(num - diff - diff))
                count++;

            set.add(num);
        }

        return count;
    }
}

