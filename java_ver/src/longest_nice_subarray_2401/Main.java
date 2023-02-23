package longest_nice_subarray_2401;

/*
    You are given an array nums consisting of positive integers.
    We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.
    Return the length of the longest nice subarray.
    A subarray is a contiguous part of an array.
    Note that subarrays of length 1 are always considered nice.
 */
public class Main {
    public int longestNiceSubarray(int[] nums) {
        /*
            Use an integer cache to save all bits that are using in current range.
            Whenever we are visiting a new number, remove from left until there is no conflict
         */
        int cache = 0, left = 0, right = 0, length = nums.length, max = 0;
        while (right < length) {
            // current number conflicts with numbers in range
            while ((cache & nums[right]) != 0)
                cache ^= nums[left++]; // Remove from left until no conflict

            // Record current bits
            cache |= nums[right];
            // Update result
            max = Math.max(max, right - left + 1);

            right++;
        }
        return max;
    }

    public static void main(String[] args){
        new Main().longestNiceSubarray(new int[]{1,3,8,48,10});
    }
}
