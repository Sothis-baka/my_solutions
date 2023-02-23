package count_number_of_distinct_integers_after_reverse_operations_2442;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) continue;
            set.add(num);
            set.add(reverse(num));
        }

        return set.size();
    }


    private int reverse(int number){
        int val = 0;

        while (number > 0){
            val = val * 10 + number % 10;
            number /= 10;
        }

        return val;
    }
}
