package jump_game_55;

/*
    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
    Return true if you can reach the last index, or false otherwise.
 */
public class Main {
    public static boolean canJump(int[] nums) {
        boolean[] cache = new boolean[nums.length];
        return jumpHelper(nums, cache, 0);
    }

    private static boolean jumpHelper(int[] nums, boolean[] cache, int index){
        if(index == nums.length - 1)
            return true;

        // Already know it can't pass
        if(cache[index])
            return false;

        int value = nums[index];
        for(int i=1; i<=value; i++){
            // Recursively call until find
            if(jumpHelper(nums, cache, index + i)){
                return true;
            }

            // Can't pass, save to cache
            cache[index + i] = true;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{0,0,0,0,0}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{1}));
    }
}
