package house_robber_ii_213;

/*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class Main {
    public int rob(int[] nums){
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }

        Integer[][] cache = new Integer[length][length];

        return Math.max(robHelper(nums, 0, nums.length-2, cache), robHelper(nums, 1, nums.length-1, cache));
    }

    private int robHelper(int[] nums, int start, int end, Integer[][] cache){
        if(end==start){
            return nums[start];
        }else if(end == start + 1){
            return Math.max(nums[start], nums[end]);
        }else{
            if(cache[start][end] == null){
                cache[start][end] = Math.max(nums[start] + robHelper(nums, start+2, end, cache), Math.max(robHelper(nums, start+1, end-1, cache), nums[end] + robHelper(nums, start, end-2, cache)));
            }

            return cache[start][end];
        }
    }

   /* public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }

        int[] cache1 = new int[length];
        int[] cache2 = new int[length];

        cache1[0] = nums[0];
        cache1[1] = nums[0];
        cache2[0] = 0;
        cache2[1] = nums[1];

        for(int i=2; i<length; i++){
            cache1[i] = Math.max(cache1[i-1], cache1[i-2] + nums[i]);
            cache2[i] = Math.max(cache2[i-1], cache2[i-2] + nums[i]);
        }

        return Math.max(cache1[length-2], cache2[length-1]);
    }*/
}
