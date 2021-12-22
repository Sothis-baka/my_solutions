package permutation_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Main {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> li = new ArrayList<>(nums.length);
        for (int num: nums) {
            li.add(num);
        }
        permuteHelper(li, new ArrayList<Integer>(), result);

        return result;
    }

    private static void permuteHelper(List<Integer> originList, List<Integer> curList, List<List<Integer>> result){
        if(originList.size() == 0){
            result.add(curList);
            return;
        }

        for(int i=0; i<originList.size(); i++){
            List<Integer> originCopy = new ArrayList<>(originList);
            List<Integer> curCopy = new ArrayList<>(curList);

            curCopy.add(originCopy.remove(i));
            permuteHelper(originCopy, curCopy, result);
        }
    }

    public static void main(String[] args){
        System.out.println(permute(new int[]{1}));
    }
}
