package running_sum_of_1d_array_1480;

/*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
 */
public class Main {
    public int[] runningSum(int[] nums) {
        // Create output array (same length)
        int length = nums.length;
        int[] result = new int[length];

        // For each num in input, add it to sum, save current sum value to result array
        result[0] = nums[0];
        for(int i=1; i<length; i++){
            result[i] = result[i-1] + nums[i];
        }

        return result;
    }
}
