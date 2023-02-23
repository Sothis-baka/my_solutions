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
        helper(new ArrayList<>(), candidates, 0, target, result, 0);
        return result;
    }

    private static void helper(List<Integer> cur, int[] candidates, int curVal, int target, List<List<Integer>> result, int lastNum){
        if(curVal >= target){
            if(curVal == target) result.add(new ArrayList<>(cur));

            return;
        }

        for(int num: candidates){
            if(num < lastNum) continue;
            cur.add(num);
            helper(cur, candidates, curVal + num, target, result, num);
            cur.remove(cur.size() - 1);
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
