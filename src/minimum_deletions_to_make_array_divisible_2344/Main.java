package minimum_deletions_to_make_array_divisible_2344;

import java.util.Arrays;

public class Main {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        return helper(nums, 0, numsDivide);
    }

    private int helper(int[] nums, int index, int[] numsDivide){
        if(index == nums.length) return -1;

        int cur = nums[index];
        for(int num: numsDivide){
            if(num / cur * cur != num){
                int count = 0;
                while (index < nums.length && nums[index] == cur) {
                    index++;
                    count++;
                }
                int result = helper(nums, index, numsDivide);
                if(result < 0) return result;
                return result + count;
            }
        }

        return 0;
    }
}
