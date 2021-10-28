package remove_duplicates_from_sorted_array_26;

/*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
    Return k after placing the final result in the first k slots of nums.
 */
public class Main {
    public static int removeDuplicates(int[] nums) {
        int indexL = 0, indexR = 0, length = nums.length, cur = Integer.MIN_VALUE;
        while(indexR < length){
            int value = nums[indexR];
            // Duplicate
            if(value == cur){
                indexR++;
                continue;
            }

            // Switch new value to end of left list
            int temp = nums[indexL];
            nums[indexL] = nums[indexR];
            nums[indexR] = temp;
            indexR++;
            indexL++;
            // Update cur value
            cur = value;
        }

        return indexL;
    }


    public static void main(String[] args){
        int[] nums = {1,1,2};
        for (int temp: nums){
            System.out.print(temp + " ");
        }
        System.out.println();
        System.out.println(removeDuplicates(nums));
        for (int temp: nums){
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
