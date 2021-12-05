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
        List<Integer> curList = new ArrayList<>();
        Arrays.sort(candidates);

        sumHelper(candidates, 0, 0, target, curList, result);

        return result;
    }

    private static void sumHelper(int[] candidates, int index, int curSum, int target, List<Integer> curList, List<List<Integer>> result){
        if(curSum == target){
            result.add(curList);
        }else if(curSum < target){
            for(int i=index; i<candidates.length; i++){
                int val = candidates[i];
                List<Integer> newList = new ArrayList<>(curList);
                newList.add(val);

                sumHelper(candidates, i+1, curSum+val, target, newList, result);

                // Skip repeat values
                while(i+1 < candidates.length && candidates[i+1] == val){
                    i++;
                }
            }
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
