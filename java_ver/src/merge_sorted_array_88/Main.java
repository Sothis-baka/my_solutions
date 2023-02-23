package merge_sorted_array_88;

import java.util.Arrays;

/*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class Main {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m-1, r = n-1, index = m+n-1;
        while(index >= 0){
            if(r < 0){
                swap(nums1, nums1, l, index);
                index--;
                l--;
            }else if(l < 0 || nums1[l] < nums2[r]){
                swap(nums1, nums2, index, r);
                index--;
                r--;
            }else{
                swap(nums1, nums1, l, index);
                index--;
                l--;
            }
        }
    }

    private void swap(int[] arr1, int[] arr2, int l, int r){
        int temp = arr1[l];
        arr1[l] = arr2[r];
        arr2[r] = temp;
    }
}
