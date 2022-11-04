package count_number_of_bad_pairs_2364;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public long countBadPairs(int[] nums) {
        // Greedy
        // val(i) = nums[i] - i; if val(i) == val(j), they are not a bad pair

        long length = nums.length, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<length; i++){
            int val = nums[i] - i;
            count += map.getOrDefault(val, 0);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return length * (length - 1) / 2 - count;
    }
}
