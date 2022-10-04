package minimum_replacements_to_sort_the_array_2366;

/*
    You are given a 0-indexed integer array nums. In one operation you can replace any element of the array with any two elements that sum to it.

    For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].
    Return the minimum number of operations to make an array that is sorted in non-decreasing order.
 */
public class Main {
    public long minimumReplacement(int[] nums) {
        /*
            Start from end to start
            if nums[i - 1] > nums[i]
            we need to divide nums[i - 1]
            and leave the left most division as large as possible

            if nums need to be divided into n numbers
            the largest possible value is nums / n

            and count will increase by n - 1
         */
        long result = 0;

        int length = nums.length, max = nums[length - 1];
        for(int i = length - 2; i >=0; i--){
            int val = nums[i];
            if(val > max){
                int times = val / max;
                if(times * max < val) times++;
                result += times - 1;
                max = val / times;
            }else max = val;
        }

        return result;
    }
}
