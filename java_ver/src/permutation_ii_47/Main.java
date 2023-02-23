package permutation_ii_47;

import java.util.*;

/*
    Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public class Main {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> candidates = new HashMap<>();
        for (int temp: nums){
            candidates.put(temp, candidates.getOrDefault(temp, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        permuteUniqueHelper(candidates, curList, result);

        return result;
    }

    private static void permuteUniqueHelper(Map<Integer, Integer> candidates, List<Integer> curList, List<List<Integer>> result){
        if(candidates.size() == 0){
            // Finished
            result.add(curList);
            return;
        }

        Set<Integer> keys = candidates.keySet();
        for(int temp: keys){
            Map<Integer, Integer> mapCopy = new HashMap<>(candidates);
            List<Integer> listCopy = new ArrayList<>(curList);

            // Move a candidate to cur list
            int count = mapCopy.get(temp);
            if(count == 1){
                mapCopy.remove(temp);
            }else{
                mapCopy.put(temp, mapCopy.get(temp) - 1);
            }

            listCopy.add(temp);

            // Recursively run until finished
            permuteUniqueHelper(mapCopy, listCopy, result);
        }
    }

    public static void main(String[] args){
        List<List<Integer>> result = permuteUnique(new int[]{1});
        for(List<Integer> temp: result){
            System.out.println(temp);
        }
    }
}
