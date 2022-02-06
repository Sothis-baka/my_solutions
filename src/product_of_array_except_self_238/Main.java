package product_of_array_except_self_238;

import java.util.Arrays;

/*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class Main {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, 1);

        result[0] = 1;
        int left = 1;
        for(int i=1; i<length; i++){
            left *= nums[i-1];
            result[i] = left;
        }

        int right = 1;
        for(int i=length-2; i>=0; i--){
            right *= nums[i + 1];
            result[i] *= right;
        }

        return result;
    }
}
