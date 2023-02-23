package wiggle_sort_ii_324;

import java.util.Arrays;

/*
    Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
    You may assume the input array always has a valid answer.
 */
public class Main {
    public static void wiggleSort(int[] nums) {
        int length = nums.length;
        int[] copy = Arrays.copyOf(nums, length);
        Arrays.sort(copy);

        int left = (length + 1) / 2 - 1, right = length - 1;
        for(int i=0; i<length; i++){
            if(i % 2 == 0){
                nums[i] = copy[left];
                left--;
            }else{
                nums[i] = copy[right];
                right--;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {1,3,2,2,3,1};
        for(int temp: arr){
            System.out.println(temp);
        }
        wiggleSort(arr);
        for(int temp: arr){
            System.out.println(temp);
        }
    }
}
