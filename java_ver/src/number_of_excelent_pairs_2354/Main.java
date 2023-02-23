package number_of_excelent_pairs_2354;

import java.util.*;

/*
    You are given a 0-indexed positive integer array nums and a positive integer k.

    A pair of numbers (num1, num2) is called excellent if the following conditions are satisfied:

    Both the numbers num1 and num2 exist in the array nums.
    The sum of the number of set bits in num1 OR num2 and num1 AND num2 is greater than or equal to k, where OR is the bitwise OR operation and AND is the bitwise AND operation.
    Return the number of distinct excellent pairs.

    Two pairs (a, b) and (c, d) are considered distinct if either a != c or b != d. For example, (1, 2) and (2, 1) are distinct.
 */
public class Main {
    public long countExcellentPairs(int[] nums, int k) {
        /*
            a&b + a|b = digits(a) + digits(b)
         */
        // Remove duplicates
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        int[] cache = new int[30];
        for(int num: set){
            cache[Integer.bitCount(num)]++;
        }

        int length = cache.length, count = 0;
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(i + j >= k) count += cache[i] * cache[j];
            }
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(new Main().countExcellentPairs(new int[]{1,2,3,1}, 3));
    }
}