package minimum_adjacent_swaps_to_make_a_valid_array_2340;

/*
    You are given a 0-indexed integer array nums.

    Swaps of adjacent elements are able to be performed on nums.

    A valid array meets the following conditions:

    The largest element (any of the largest elements if there are multiple) is at the rightmost position in the array.
    The smallest element (any of the smallest elements if there are multiple) is at the leftmost position in the array.
    Return the minimum swaps required to make nums a valid array.
 */
public class Main {
    public int minimumSwaps(int[] nums) {
        if(nums.length == 1) return 0;
        /*
            Iterate through the array and find the index of the minimum element and the maximum element.
         */
        int length = nums.length, min = Integer.MAX_VALUE, max = 0, min_index = 0, max_index = 0;
        for(int i=0; i<length; i++){
            if(nums[i] < min){
                min = nums[i];
                min_index = i;
            }

            if(nums[i] >= max){
                max = nums[i];
                max_index = i;
            }
        }

        if(min_index < max_index){
            return min_index + (length - 1 - max_index);
        }
        else{
            return min_index + (length - 1 - max_index) - 1;
        }
    }
}
