package search_in_rotated_sorted_array_33;

/*
    There is an integer array nums sorted in ascending order (with distinct values).
    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    You must write an algorithm with O(log n) runtime complexity.
 */
public class Main {
    public static int search(int[] nums, int target) {
        return searchHelp(nums, target, 0, nums.length-1);
    }

    public static int searchHelp(int[] nums, int target, int left, int right){
        if(left > right){
            return -1;
        }

        int leftV = nums[left];
        if(leftV == target){
            return left;
        }

        int rightV = nums[right];
        if(rightV == target){
            return right;
        }

        if(left == right){
            return -1;
        }

        int pivot = (left + right) / 2;
        int pivotV = nums[pivot];

        if(pivotV == target){
            return pivot;
        }

        if(pivotV < target){
            int result = searchHelp(nums, target, pivot+1, right-1);
            if(result < 0){
                return searchHelp(nums, target, left+1, pivot-1);
            }else{
                return result;
            }
        }else{
            int result = searchHelp(nums, target, left+1, pivot-1);
            if(result < 0){
                return searchHelp(nums, target, pivot+1, right-1);
            }else{
                return result;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 1));
    }
}
