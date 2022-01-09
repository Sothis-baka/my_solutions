package search_in_rotated_sorted_array_ii_81;

/*
    There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
    Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
    Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
    You must decrease the overall operation steps as much as possible.
 */
public class Main {
    public static boolean search(int[] nums, int target) {
        // Check margin
        if(nums[0] == target || nums[nums.length-1] == target){
            return true;
        }

        return searchHelper(nums, target, 0, nums.length - 1);
    }

    /*
        If nums[pivot] > nums[right]:
            nums[0:pivot] is in order
        If nums[pivot] < nums[left]:
            nums[pivot:length-1] is in order
     */
    private static boolean searchHelper(int[] nums, int target, int left, int right){
        // Finished search
        if(left >= right - 1){
            return false;
        }

        int mid = (left + right) / 2;
        if(nums[mid] == target){
            // Find
            return true;
        }else if(nums[mid] < target){
            if(nums[mid] > nums[right]){
                // All number on left is smaller than mid value, should search on right
                return searchHelper(nums, target, mid, right);
            }else if(nums[mid] < nums[left]){
                if(nums[right] > target){
                    // Target should be on left, and left nums are in order
                    return binarySearchHelper(nums, target, mid, right);
                }else{
                    // Target should be on right
                    return searchHelper(nums, target, left, mid);
                }
            }else{
                // Can't determine, search each part
                if(searchHelper(nums,target, left, mid)){
                    return true;
                }else{
                    return searchHelper(nums, target, mid, right);
                }
            }
        }else{
            if(nums[mid] > nums[right]){
                if(nums[left] < target){
                    // Should be on right, and all nums on right is in order
                    return binarySearchHelper(nums, target, left, mid);
                }else{
                    // Should be on left
                    return searchHelper(nums, target, mid, right);
                }
            }else if(nums[mid] < nums[left]){
                // Should be on left since all nums on right is larger
                return searchHelper(nums, target, left, mid);
            }else{
                // Can't determine, check each side
                if(searchHelper(nums, target, left, mid)){
                    return true;
                }else{
                    return searchHelper(nums, target, mid, right);
                }
            }
        }
    }

    private static boolean binarySearchHelper(int[] nums, int target, int left, int right){
        while(left < right - 1){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }

        return false;
    }

    public static void main(String[] args){
        /*System.out.println(search(new int[]{2,5,6,0,0,1,2}, 5));
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(search(new int[]{4,5,6,0,0,1,2}, 3));*/
        System.out.println(search(new int[]{1,1,1,13,1,1,1,1,1}, 13));
    }
}
