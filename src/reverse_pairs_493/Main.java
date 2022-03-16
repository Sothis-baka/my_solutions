package reverse_pairs_493;

import java.util.ArrayList;
import java.util.List;

/*
    Given an integer array nums, return the number of reverse pairs in the array.
    A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
 */
public class Main {
    public static int reversePairs(int[] nums) {
        if(nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int start, int end){
        if(start >= end) return 0;

        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);

        for(int i=start, j=mid+1; i<=mid && j <= end;){
            if(nums[i] / 2.0 > nums[j]){
                count += mid - i + 1;
                j++;
            }else{
                i++;
            }
        }

        merge(nums, start, end);
        return count;
    }

    private static void merge(int[] nums, int start, int end){
        int mid = start + (end - start) / 2;
        int[] copy = new int[end - start + 1];

        int i=start, j = mid+1, k=0;
        while(k < copy.length){
            int num1 = i > mid ? Integer.MAX_VALUE : nums[i];
            int num2 = j > end ? Integer.MAX_VALUE : nums[j];

            copy[k++] = num1 <= num2 ? nums[i++] : nums[j++];
        }

        for(k=0; k<copy.length; k++) nums[k + start] = copy[k];
    }

    public static void main(String[] args){
        System.out.println(reversePairs(new int[]{1,2,3,2,1}));
    }
}
