package shuffle_an_array_384;

import java.util.*;

public class Solution {
    int[] nums;
    Random roll;

    public Solution(int[] nums) {
        this.nums = nums;
        roll = new Random();
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] copy = this.nums.clone();
        for(int i=0; i<copy.length; i++){
            swap(copy, i, roll.nextInt(copy.length));
        }
        return copy;
    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /*int[] nums;
    List<int[]> choices;
    Random roll;

    public Solution(int[] nums) {
        this.nums = nums;
        this.choices = new ArrayList<>();
        this.roll = new Random();

        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        solutionHelper(sortedNums, 0, new int[nums.length], 0);
    }

    private void solutionHelper(int[] sortedNums, int index, int[] cur, int count){
        if(count == cur.length){
            choices.add(cur.clone());
        }

        int last = Integer.MIN_VALUE;
        for(int i=index; i<sortedNums.length; i++){
            int num = sortedNums[i];
            if(num != last){
                cur[count] = num;
                solutionHelper(sortedNums, i+1, cur, count+1);

                last = num;
            }
        }
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        return this.choices.get(roll.nextInt(this.choices.size()));
    }*/
}
