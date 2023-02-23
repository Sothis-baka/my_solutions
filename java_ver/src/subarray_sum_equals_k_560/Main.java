package subarray_sum_equals_k_560;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 */
public class Main {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);

        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += cache.getOrDefault(sum - k, 0);
            cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
