package house_robber_198;

public class Main {
    public int rob(int[] nums) {
        int length = nums.length;

        switch(length){
            case 0:
                return 0;
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
            default:
                int[] cache = new int[length];
                cache[0] = nums[0];
                cache[1] = nums[1];
                for(int i=2; i<length; i++){
                    cache[i] = Math.max(cache[i-2] + nums[i], Math.max(cache[i-1], cache[i-1] - nums[i-1] + nums[i]));
                }

                return cache[length-1];
        }
    }
}
