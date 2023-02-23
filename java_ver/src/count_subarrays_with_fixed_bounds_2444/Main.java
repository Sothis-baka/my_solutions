package count_subarrays_with_fixed_bounds_2444;

public class Main {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        /*
            Save the index of possible start point, possible end point
            and the minK, maxK index in the range
         */
        int l = 0, r = 0, length = nums.length, minIndex = -1, maxIndex = -1;
        long count = 0;
        /* Double pointer */
        while (r < length){
            int val = nums[r];
            // Not meet requirement
            if(val < minK || val > maxK){
                r = l = r + 1;
                continue;
            }

            if(val == minK) minIndex = r;
            if(val == maxK) maxIndex = r;

            int diff = Math.min(minIndex, maxIndex) - l + 1;
            // The number of sub-arrays that are valid ends at r
            count += Math.max(0, diff);

            r++;
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(new Main().countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
    }
}
