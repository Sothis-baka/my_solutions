package split_array_into_consecutive_subsequences_659;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    You are given an integer array nums that is sorted in non-decreasing order.
    Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:

    Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
    All subsequences have a length of 3 or more.
    Return true if you can split nums according to the above conditions, or false otherwise.

    A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).
*/
public class Main {
    // Greedy search
    public static boolean isPossible(int[] nums) {
        int length = nums.length;

        int c1,c2,c3,l1=0,l2=0,l3=0,last = Integer.MIN_VALUE;
        for(int i=0; i<length; i++){
            System.out.printf("%d, %d, %d\n", l1, l2, l3);

            int count = 0;
            int cur = nums[i];
            for(; i < length && nums[i] == cur; i++){
                count++;
            }
            i--;

            if(cur == last + 1){
                if(count >= l2){
                    c3 = l2;
                    count -= l2;
                }else return false;

                if(count >= l1){
                    c2 = l1;
                    count -= l1;
                }else return false;

                c3 += Math.min(count, l3);
                count -= Math.min(count, l3);
            }else{
                if(l1 != 0 || l2 != 0) return false;

                c2 = 0;
                c3 = 0;
            }

            c1 = count;
            l1 = c1;
            l2 = c2;
            l3 = c3;

            last = cur;
        }

        return l1 == 0 && l2 == 0;
    }

    public static void main(String[] args){
        System.out.println(isPossible(new int[]{1,2,3,3,4,5}));
    }
}
