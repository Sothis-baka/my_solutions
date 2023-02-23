package max_sum_of_a_pair_with_equal_sum_of_digits_2342;

import java.util.HashMap;
import java.util.Map;

/*
    You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
    Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
 */
public class Main {
    public int maximumSum(int[] nums) {
        int max = -1;
        Map<Integer, Integer> cache = new HashMap<>();

        for(int num: nums){
            int sum = sumOfDigits(num);
            if(cache.containsKey(sum)){
                int last = cache.get(sum);
                max = Math.max(max, last + num);
                cache.put(sum, Math.max(last, num));
            }else{
                cache.put(sum, num);
            }
        }

        return max;
    }

    private int sumOfDigits(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /=10;
        }
        return sum;
    }
}
