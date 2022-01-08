package remove_duplicates_from_sorted_array_ii_80;

/*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
    Return k after placing the final result in the first k slots of nums.
    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Main {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length, index = 0, left = 0, cur = Integer.MIN_VALUE;
        boolean repeat = false;
        while (index < length){
            int temp = nums[index];
            if(temp > cur){
                // New number, save
                cur = temp;
                swap(nums, index, left);
                left++;
                // Reset flag
                repeat = false;
            }else if(temp == cur){
                if(!repeat){
                    // Repeat once
                    swap(nums, index, left);
                    left++;
                    // Record with flag
                    repeat = true;
                }
            }

            index++;
        }

        // left - 1 is the last index, but we count from index 0, so return left
        return left;
    }

    // Helper function to swap two elements in array
    private static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args){
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
