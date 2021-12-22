package first_missing_positive_41;

/*
    Given an unsorted integer array nums, return the smallest missing positive integer.
    You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */
public class Main {
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] outer = new int[length];

        for (int temp: nums){
            if(temp > 0 && temp <= length){
                outer[temp-1] = 1;
            }
        }

        for(int i=0; i<length; i++){
            if(outer[i] == 0){
                return i + 1;
            }
        }

        return length + 1;
    }
}
