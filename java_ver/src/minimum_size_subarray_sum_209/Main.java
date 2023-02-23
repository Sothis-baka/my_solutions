package minimum_size_subarray_sum_209;

public class Main {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, sum=0, minL=Integer.MAX_VALUE, length=nums.length;
        while (r < length){
            sum += nums[r++];
            while (sum >= target && l < r) {
                minL = Math.min(minL, r - l);
                sum -= nums[l++];
            }
        }

        return minL == Integer.MAX_VALUE ? 0 : minL;
    }
}
