package largest_positive_integer_that_exists_with_its_negative_2441;

import java.util.HashSet;
import java.util.Set;

/*
    Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
    Return the positive integer k. If there is no such integer, return -1.
 */
public class Main {
    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(-num)) max = Math.max(max, Math.abs(num));
            else set.add(num);
        }

        return max;
    }
}
