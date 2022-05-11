package kth_largest_element_in_an_array_215;

import java.util.Random;

/*
    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class Main {
    static Random roll = new Random();

    public static int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length-1, k);
    }

    private static int partition(int[] nums, int start, int end, int k){
        if(start >= end) return nums[end];
        int pivot = roll.nextInt(end - start) + start;
        swap(nums, start, pivot);

        int val = nums[start];
        int i =start + 1, index = start + 1;
        while(i <= end){
            if(nums[i++] < val) swap(nums, i - 1, index++);
        }

        swap(nums, start, --index);
        if(end - index == k - 1) return nums[index];
        else if(end - index < k - 1) return partition(nums, start, index - 1, k - (end - index + 1));
        else return partition(nums, index + 1, end, k);
    }

    private static void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args){
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(findKthLargest(new int[]{1}, 1));
    }
}
