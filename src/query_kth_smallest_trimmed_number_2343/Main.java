package query_kth_smallest_trimmed_number_2343;

import java.util.*;

/*
    You are given a 0-indexed array of strings nums, where each string is of equal length and consists of only digits.

    You are also given a 0-indexed 2D integer array queries where queries[i] = [ki, trimi]. For each queries[i], you need to:

    Trim each number in nums to its rightmost trimi digits.
    Determine the index of the kith smallest trimmed number in nums. If two trimmed numbers are equal, the number with the lower index is considered to be smaller.
    Reset each number in nums to its original length.
    Return an array answer of the same length as queries, where answer[i] is the answer to the ith query.
*/
public class Main {
    static class Num{
        int index;
        String value;

        Num(int index, String value){
            this.index = index;
            this.value = value;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int numL = nums.length, wordL = nums[0].length();

        // Create a structure for result
        int[] result = new int[numL];

        // Mark every element so that I can identify them
        List<Num> list = new ArrayList<>();
        for(int i=0; i<numL; i++){
            list.add(new Num(i, nums[i]));
        }

        /*
            For each possible value of trim, sort the array with their substrings.
            For each possible k with current trim, find it's previous position and fill into result
         */
        // Process queries, also need to remember its index in queries which is the same as in result
        Map<Integer, Map<Integer, List<Integer>>> cache = new HashMap<>();
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            // Trim -> K -> indexes (since k is counted from 1, subtract it by 1)
            cache.computeIfAbsent(query[1], k -> new HashMap<>())
                    .computeIfAbsent(query[0] - 1, k -> new ArrayList<>()).add(i);
        }

        // Iterate, sort, and fill
        for(int trim: cache.keySet()){
            list.sort((a, b) -> {
                String str1 = a.value.substring(wordL - trim), str2 = b.value.substring(wordL - trim);
                // Use the lower index if they are the same
                if(str1.equals(str2)){
                    return a.index - b.index;
                }else return str1.compareTo(str2);
            });

            Map<Integer, List<Integer>> pair = cache.get(trim);
            for(int i=0; i<numL; i++){
                // is k
                if(pair.containsKey(i)){
                    for(int pos: pair.get(i)){
                        result[pos] = list.get(i).index;
                    }
                }
            }
        }

        return result;
    }
}
