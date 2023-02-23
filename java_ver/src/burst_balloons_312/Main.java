package burst_balloons_312;

/*
    You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
    If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
    Return the maximum coins you can collect by bursting the balloons wisely.
 */
public class Main {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] newNums = new int[length + 2];
        newNums[0] = 1;
        System.arraycopy(nums, 0, newNums, 1, length);
        newNums[length + 1] = 1;
        int[][] cache = new int[length + 2][length + 2];

        return coinHelper(newNums, 0, length + 1, cache);
    }

    private int coinHelper(int[] nums, int start, int end, int[][] cache){
        if(start >= end - 1){
            return 0;
        }
        if(cache[start][end] != 0){
            return cache[start][end];
        }

        int max = 0;
        for(int i=start+1; i<end; i++){
            max = Math.max(max, nums[start] * nums[i] * nums[end] + coinHelper(nums, start, i, cache) + coinHelper(nums, i, end, cache));
        }
        cache[start][end] = max;
        return max;
    }
}
