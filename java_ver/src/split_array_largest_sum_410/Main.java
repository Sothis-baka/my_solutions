package split_array_largest_sum_410;

/*
    Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
    Write an algorithm to minimize the largest sum among these m subarrays.
 */
public class Main {
    public static int splitArray(int[] nums, int m) {
        int length = nums.length;
        Integer[][] cache = new Integer[length][m + 1];
        int[] sums = new int[length + 1];
        for(int i=0; i<length; i++){
            sums[i+1] = sums[i] + nums[i];
        }
        return tryFind(nums, 0, m, cache, sums);
    }

    private static int tryFind(int[] nums, int index, int m, Integer[][] cache, int[] sums){
        // Finished
        if (m == 1) return sums[nums.length] - sums[index];
        // Visited
        if(cache[index][m] != null) return cache[index][m];

        int min = Integer.MAX_VALUE;
        for(int i=index; i<nums.length - m; i++){
            int sum = sums[i+1] - sums[index];
            int result = tryFind(nums, i+1, m-1, cache, sums);
            // Update if find a smaller result
            min = Math.min(min, Math.max(sum, result));
        }

        cache[index][m] = min;
        return min;
    }

    public static void main(String[] args){
        System.out.println(splitArray(new int[]{7,2,5,10,8}, 2));
    }
}
