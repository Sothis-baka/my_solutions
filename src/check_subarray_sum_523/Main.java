package check_subarray_sum_523;

import java.util.HashSet;
import java.util.Set;

/*
    Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 */
public class Main {

    public boolean checkSubarraySum(int[] nums, int k) {
        /*
            Save visited remainders, when visit a k, update remainders
            The subarray has remainder 0 if the value appeared earlier
         */
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int sum = 0, last = -1;
        for(int num: nums){
            // Can't be two sibling elements
            if(num % k == 0){
                if(last == 0) return true;
                last = 0;
                continue;
            }else last = -1;
            sum = (sum + num) % k;
            if(visited.contains(sum)) return true;
            visited.add(sum);
        }

        return false;
    }
}
