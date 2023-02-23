package next_permutation_31;

/*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
    The replacement must be in place and use only constant extra memory.
 */
public class Main {
    public static void nextPermutation(int[] nums) {
        int length = nums.length;

        /* All operations are done from the last digit to the first digit */
        /* An example here is [1,2,4,4,3] */

        // Find the first one not in order
        /* In this situation, it's 2. [1,*2*,4,4,3] */
        int target = -1;
        for(int i=1; i<length; i++){
            int index = length-i;
            if(nums[index] > nums[index-1]){
                target = index - 1;
                break;
            }
        }

        if(target == -1){
            // The array is in highest order, reverse it.
            reverse(nums, 0, length-1);
        }else {
            // Replace target number with the one higher than it.
            // The array after target is in descendant order, just find the first one higher than it.
            /*  In this situation, it's 3. [1,*2*,4,4,-3-]  */
            int cur = nums[target];
            for(int i=length-1; i>target; i--){
                if(nums[i] > cur){
                    swap(nums, i, target);
                    break;
                }
            }

            /* Now the array is [1,3,4,4,2] */
            // Sort arrays after that, from highest to lowest
            reverse(nums, target+1, length-1);

            /* Now the array is [1,3,2,2,4] */
        }
    }

    public static void reverse(int[] nums, int i, int j){
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int modifyLength = unfulfilledLength(nums);

        if(modifyLength == -1){
            // The whole array is at the highest, sort it to the lowest.
            sortLowest(nums, length);
        }else {
            // Swap the target one with the one just higher than that
            int cur = nums[length - modifyLength], next=Integer.MAX_VALUE, index=-1;
            for(int i=1; i<modifyLength; i++){
                int temp = nums[length - i];
                if(temp > cur && temp < next) {
                    next = temp;
                    index = length - i;
                }
            }
            nums[length - modifyLength] = nums[index];
            nums[index] = cur;

            // Then sort things after the target to the lowest
            sortLowest(nums, modifyLength - 1);
        }


    }

    // Read from last, find the length of array not fulfill highest rule.
    public static int unfulfilledLength(int[] nums){
        int length = nums.length;

        // n is the number of digits need to be checked. 1 < n < length
        for(int i=1; i<length; i++){
            if(nums[length - i] > nums[length - i - 1]){
                return i + 1;
            }
        }

        return -1;
    }

    // From the last digit, sort digits length of the array to lowest
    public static void sortLowest(int[] nums, int digits){
        int length = nums.length, left, right;

        // Bubble sort
        for(int i=0; i<digits-1; i++){
            for(int j=0; j<digits-1-i; j++){
                left = nums[length-digits+j];
                right = nums[length-digits+j+1];
                if(left > right){
                    nums[length-digits+j] = right;
                    nums[length-digits+j+1] = left;
                }
            }
        }
    }*/

    // Helper functions to visualize array
    public static void printNums(int[] nums){
        for(int temp: nums){
            System.out.print(temp);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] nums = {1};

        printNums(nums);
        nextPermutation(nums);
        printNums(nums);
    }
}
