package maximum_subarray_53;

public class Main {
    public static int maxSubArray(int[] nums){
        int sum=0, min = 0, maxDiff=Integer.MIN_VALUE;

        for (int num : nums) {
            // Sum to current index
            sum += num;

            // Sum from minIndex to current index.
            int diff = (min == Integer.MAX_VALUE) ? sum : sum - min;
            if (diff > maxDiff) {
                maxDiff = diff;
            }

            if (sum < min) {
                min = sum;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args){
        System.out.println(maxSubArray(new int[]{5}));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
