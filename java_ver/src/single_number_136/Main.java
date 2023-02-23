package single_number_136;

import java.util.*;

/*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class Main {
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int temp: nums){
            if(set.contains(temp)){
                set.remove(temp);
            }else{
                set.add(temp);
            }
        }

        for(int result: set){
            return result;
        }

        return 0;
    }

    public static void main(String[] args){
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }
}
