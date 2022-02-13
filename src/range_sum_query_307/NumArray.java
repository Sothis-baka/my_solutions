package range_sum_query_307;

/*
    Given an integer array nums, handle multiple queries of the following types:

    Update the value of an element in nums.
    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
    Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    void update(int index, int val) Updates the value of nums[index] to be val.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
*/
public class NumArray {
    int[] nums, sums;
    int length;

    public NumArray(int[] nums) {
        int sum = 0;
        this.length = nums.length;
        this.nums = nums;
        this.sums = new int[length];

        for(int i=0; i<this.length; i++){
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;

        for(int i=index; i<this.length; i++){
            sums[i] += diff;
        }
    }

    public int sumRange(int left, int right) {
        return sums[right] - (left == 0 ? 0 : sums[left-1]);
    }
}
