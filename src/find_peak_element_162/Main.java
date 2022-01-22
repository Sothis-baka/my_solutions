package find_peak_element_162;

import java.util.Set;

/*
    A peak element is an element that is strictly greater than its neighbors.
    Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
    You may imagine that nums[-1] = nums[n] = -∞.
    You must write an algorithm that runs in O(log n) time.
 */
public class Main {
    public static int findPeakElement(int[] nums) {
        return peakHelper(nums, 0, nums.length - 1);
    }

    private static int peakHelper(int[] nums, int start, int end){
        if(start == end){
            return start;
        }

        if(end - start == 1){
            if(nums[start] == nums[end]){
                return -1;
            }else{
                return nums[start] > nums[end] ? start : end;
            }
        }

        int mid = (start + end) / 2;
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
            return mid;
        }

        if(nums[mid] < nums[mid-1]){
            int result = peakHelper(nums, start, mid-1);
            if(result != -1){
                return result;
            }
        }

        return peakHelper(nums, mid+1, end);
    }

    public static void main(String[] args){
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }
}
