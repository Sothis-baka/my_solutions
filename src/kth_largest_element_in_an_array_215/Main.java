package kth_largest_element_in_an_array_215;

/*
    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class Main {
    public static int findKthLargest(int[] nums, int k) {
        return findHelper(nums, 0, nums.length-1, k);
    }

    private static int findHelper(int[] nums, int left, int right, int k){
        // Pivot value
        int pivot = nums[right];

        // Quick sort
        int index = left;
        for(int i=left; i<right; i++){
            if(nums[i] < pivot){
                swap(nums, index, i);
                index++;
            }
        }

        swap(nums, index, right);

        int count = right - index + 1;
        if(count == k){
            return nums[index];
        }else if(count > k){
            return findHelper(nums, index+1, right, k);
        }else{
            return findHelper(nums, left, index-1, k-count);
        }
    }

    // Helper function to swap values in the array
    private static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    // Helper function to print out the array
    private static void printIt(int[] nums){
        for(int temp: nums){
            System.out.print(temp);
        }
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(findKthLargest(new int[]{1}, 1));
    }
}
