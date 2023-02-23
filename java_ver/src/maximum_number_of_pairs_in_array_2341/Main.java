package maximum_number_of_pairs_in_array_2341;

import java.util.HashSet;
import java.util.Set;

/*
    You are given a 0-indexed integer array nums. In one operation, you may do the following:

    Choose two integers in nums that are equal.
    Remove both integers from nums, forming a pair.
    The operation is done on nums as many times as possible.

    Return a 0-indexed integer array answer of size 2 where answer[0] is the number of pairs that are formed and answer[1] is the number of leftover integers in nums after doing the operation as many times as possible.
 */
public class Main {
    // Greedy search
    public int[] numberOfPairs(int[] nums) {
        int pairs = 0;

        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                set.remove(num);
                pairs++;
            }else{
                set.add(num);
            }
        }

        return new int[]{pairs, nums.length - pairs * 2};
    }
}
