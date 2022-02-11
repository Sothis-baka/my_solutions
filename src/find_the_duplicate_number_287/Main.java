package find_the_duplicate_number_287;

/*
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    There is only one repeated number in nums, return this repeated number.
    You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class Main {
    public int findDuplicate(int[] nums) {
        boolean[] find = new boolean[nums.length];
        for(int num: nums){
            if(find[num]){
                return num;
            }else{
                find[num] = true;
            }
        }

        return -1;
    }
}
