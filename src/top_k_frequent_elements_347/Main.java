package top_k_frequent_elements_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class Main {
    public static int[] topKFrequent(int[] nums, int k) {
        int length = nums.length;
        List<Integer>[] counts = new List[length + 1];
        Map<Integer, Integer> cache = new HashMap<>();

        for(int num: nums){
            cache.put(num, cache.getOrDefault(num, 0) + 1);
        }

        for(int num: cache.keySet()){
            int count = cache.get(num);
            if(counts[count] == null){
                counts[count] = new ArrayList<>();
            }
            counts[count].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i=length; i>=0; i--){
            if(counts[i] != null){
                for(int num: counts[i]){
                    result[index++] = num;
                }
                if(index == k){
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(topKFrequent(new int[]{1}, 1)[0]);
    }
}
