package three_sum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.
 */
public class Main {
    public static void main(String[] args){
        int[] nums = {1,1,1};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            int first = nums[i];
            // already tried this
            if(i > 0 && first == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int leftN = nums[left];
                int rightN = nums[right];
                int sum = leftN + rightN;
                if(sum == -first){
                    // save it
                    List<Integer> temp = new ArrayList<>();
                    temp.add(first);
                    temp.add(leftN);
                    temp.add(rightN);
                    result.add(temp);

                    // try to find another pair
                    do{
                        left++;
                    }while (left < right && nums[left] == leftN);
                }else if(sum < -first){
                    // try to find another pair
                    do{
                        left++;
                    }while (left < right && nums[left] == leftN);
                }else {
                    // try to find another pair
                    do{
                        right--;
                    }while (right > left && nums[right] == rightN);
                }
            }
        }

        return result;
    }

}
