package random_pick_with_weight_528;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    /*
        a/b
        for index i, P = num[i] / sum[all]


     */
    int[] nums;
    int[] preSum;
    int total;
    Random roll;

    public Solution(int[] w) {
        this.nums = w;
        this.roll = new Random();

        preSum = new int[nums.length + 1];
        for(int i=0; i<nums.length; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        total = preSum[nums.length];
    }

    public int pickIndex() {
        int pos = roll.nextInt(total);

        int index = Arrays.binarySearch(preSum, pos);
        if(index < 0) return -index - 2;
        return index;
    }
}
