package subsets_78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Main {
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int i=0; i<=nums.length; i++){
            subSetHelper(nums, i, 0, cur, result);
        }

        return result;
    }

    public static void subSetHelper(int[] nums, int size, int min, List<Integer> cur, List<List<Integer>> result){
        if(cur.size() == size){
            result.add(cur);
            return;
        }

        for(int i=min; i<nums.length; i++){
            List<Integer> copy = new ArrayList<>(cur);
            copy.add(nums[i]);
            subSetHelper(nums, size, i+1, copy, result);
        }
    }

    public static void main(String[] args){
        List<List<Integer>> result = subsets(new int[]{1,2,3});
        for(List<Integer> temp: result){
            System.out.println(temp);
        }
    }
}
