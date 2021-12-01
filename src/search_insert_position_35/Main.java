package search_insert_position_35;

/*
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.
 */
public class Main {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
        }

        int left = 0, right = nums.length - 1;

        /* Out of current range */
        if(nums[left] >= target){
            return 0;
        }

        if(nums[right] == target){
            return right;
        }else if(nums[right] < target){
            return right + 1;
        }

        /* nums[left] < target, nums[right] > target */
        while (left < right){
            // Insert between these two
            if(right == left + 1){
                return right;
            }

            int pivot = (left + right) / 2;
            if(nums[pivot] == target){
                return pivot;
            }else if(nums[pivot] < target){
                left = pivot;
            }else{
                right = pivot;
            }
        }

        return 0;
    }
}
