package single_number_ii_137;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int singleNumber(int[] nums) {
        /*
            Use a HashMap to save all counts of numbers
         */
        Map<Integer, Integer> counts = new HashMap<>();

        /*
            Iterate through the arr, count all numbers, remove the number when the count is 3
         */
        for(int num: nums){
            int newCount = counts.getOrDefault(num, 0) + 1;
            if(newCount == 3)
                counts.remove(num);
            else
                counts.put(num, newCount);
        }

        /*
            There is only one num in the set, which is the result
         */
        for(int num: counts.keySet())
            return num;

        return -1;
    }
}
