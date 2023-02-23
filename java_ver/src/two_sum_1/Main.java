package two_sum_1;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
 */
public class Main {
    public int[] twoSum(int[] nums, int target) {
        /*
            Use a hashmap to save visited values and their indexes

            For index i, find if target - i exists in the keyset of the map.
            If so, return the result, else, save current value.
        */

        // Init the map<value, index>
        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i<nums.length; i++){
            int val = nums[i];

            // Search in the map
            if(map.containsKey(target - val)){
                return new int[]{map.get(target - val), i};
            }else{
                map.put(val, i);
            }
        }

        // Default return (not found)
        return new int[]{0, 0};
    }
}
