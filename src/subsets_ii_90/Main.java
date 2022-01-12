package subsets_ii_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Main {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        subsetHelper(nums, 0, cur, result);

        return result;
    }

    private void subsetHelper(int[] nums, int start, List<Integer> cur, List<List<Integer>> result){
        result.add(cur);

        if(start == nums.length){
            return;
        }

        for(int i=start; i<nums.length; i++){
            if(i==start || nums[i] != nums[i-1]){
                List<Integer> copy = new ArrayList<>(cur);
                copy.add(nums[i]);
                subsetHelper(nums, i+1, copy, result);
            }
        }
    }
}
