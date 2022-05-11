package combination_sum_ii_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.
 */
public class Main {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] candidates, int index, int curVal, int target, List<Integer> cur, List<List<Integer>> result){
        if(curVal >= target){
            if(curVal == target) result.add(new ArrayList<>(cur));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            cur.add(candidates[i]);
            helper(candidates, i + 1, curVal + candidates[i], target, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        for(List<Integer> temp: result){
            System.out.println(temp);
        }
    }
}
