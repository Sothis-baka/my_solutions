package combination_sum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class Main {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();

        Arrays.sort(candidates);
        sumHelper(candidates, 0, 0, target, curList, result);

        return result;
    }

    public static void sumHelper(int[] candidate, int index, int curSum, int target, List<Integer> curList, List<List<Integer>> result){
        if(curSum < target){
            for(int i=index; i<candidate.length; i++){
                int val = candidate[i];
                // make a copy
                List<Integer> newList = new ArrayList<>(curList);
                newList.add(val);
                sumHelper(candidate, i, curSum+val, target, newList, result);
            }
        }else if(curSum == target){
            result.add(curList);
        }
    }

    public static void main(String[] args){
        int[] candidates = {1};
        int target = 2;
        List<List<Integer>> result = combinationSum(candidates, target);
        for(List<Integer> temp: result){
            System.out.println(temp);
        }
    }
}
