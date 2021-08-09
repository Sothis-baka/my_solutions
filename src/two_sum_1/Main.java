package two_sum_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
 */
public class Main {
    public static void main(String[] args){

    }

    public static int[] twoSum(int[] nums, int target) {
        /*
            ArrayList<Integer> list = new ArrayList<>();
            for(int temp: nums){
                list.add(temp);
            }

            for(int i=0; i<list.size(); i++){
                int temp = list.get(i);
                int needed = target - temp;
                int index = list.lastIndexOf(needed);
                if(index >=0 && index != i){
                    return new int[]{i, index};
                }
            }
        */

        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i=0; i<length; i++){
            int temp = nums[i];
            int needed = target - temp;

            if(map.containsKey(needed)){
                return new int[]{i, map.get(needed)};
            }

            // save value, index to map. hashmap is more efficient than arraylist when searching multiple times
            map.put(temp, i);
        }

        return new int[]{0, 0};
    }
}
