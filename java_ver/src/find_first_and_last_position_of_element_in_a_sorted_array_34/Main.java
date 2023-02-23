package find_first_and_last_position_of_element_in_a_sorted_array_34;

/*
    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    If target is not found in the array, return [-1, -1].
    You must write an algorithm with O(log n) runtime complexity.
 */
public class Main {
    public int[] searchRange(int[] nums, int target) {
        int targetPos = -1;

        /* Special case one only one element exists */
        if(nums.length == 1){
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }

        /* Use binary search */
        int left = 0, right = nums.length - 1;
        while (left < right){
            if(nums[left] == target){
                targetPos = left;
                break;
            }

            if(nums[right] == target){
                targetPos = right;
                break;
            }

            int pivot = (left + right) / 2;
            int pivotVal = nums[pivot];
            if(pivotVal == target){
                targetPos = pivot;
                break;
            }else if(pivotVal < target){
                left = pivot + 1;
                right--;
            }else{
                right = pivot - 1;
                left++;
            }
        }

        /* Not found */
        if(targetPos < 0){
            return new int[]{-1, -1};
        }

        /* All elements with the same value are abreast, find two on edges */
        left = targetPos;
        right = targetPos;
        while (left > 0 && nums[left-1] == target){
            left--;
        }

        while (right + 1 < nums.length && nums[right+1] == target){
            right++;
        }

        return new int[]{left, right};
    }
}
