package burst_balloons_312;

/*
    You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
    If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
    Return the maximum coins you can collect by bursting the balloons wisely.
 */
public class Main {
    public static int maxCoins(int[] nums) {
        // Add 1 to start and end
        int[] newArr = new int[nums.length + 2];
        newArr[0] = newArr[newArr.length-1] = 1;
        System.arraycopy(nums, 0, newArr, 1, nums.length);

        int[][] cache = new int[newArr.length][newArr.length];
        return helper(newArr, 0, newArr.length - 1, cache);
    }

    private static int helper(int[] nums, int left, int right, int[][] cache){
        if(left == right-1){
            return 0;
        }

        if(cache[left][right] != 0){
            return cache[left][right];
        }

        int max = 0;
        for(int i=left+1; i<right; i++){
            max = Math.max(max, nums[left] * nums[i] * nums[right] + helper(nums, left, i, cache) + helper(nums, i, right, cache));
        }
        cache[left][right] = max;

        return max;
    }

    public static void main(String[] args){
        System.out.println(maxCoins(new int[]{3,1,5,9}));
    }
}
