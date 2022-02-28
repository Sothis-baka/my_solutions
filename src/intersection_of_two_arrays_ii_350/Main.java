package intersection_of_two_arrays_ii_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
*/
public class Main {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> cache = new HashMap<>();
        for(int num: nums1){
            cache.put(num, cache.getOrDefault(num, 0) + 1);
        }

        for(int num: nums2){
            int count = cache.getOrDefault(num, 0);
            if(count > 0){
                result.add(num);
                cache.put(num, --count);
            }
        }

        int[] answer = new int[result.size()];
        int i = 0;
        for(int num: result){
            answer[i++] = num;
        }
        return answer;
    }
}
