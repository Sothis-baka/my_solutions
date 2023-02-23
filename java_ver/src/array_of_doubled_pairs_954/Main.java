package array_of_doubled_pairs_954;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public boolean canReorderDoubled(int[] arr) {
        int length = arr.length;
        Integer[] nums = new Integer[length];
        for(int i=0; i<length; i++) nums[i] = arr[i];

        Arrays.sort(nums, (a, b) -> Math.abs(a) - Math.abs(b));
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            int half = num/2;
            if(num % 2 == 0 && map.containsKey(half)){
                int count = map.get(half);
                if(count == 1){
                    map.remove(half);
                }else{
                    map.put(half, count - 1);
                }
            }else{
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return map.isEmpty();
    }
}
