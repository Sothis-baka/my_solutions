package move_zeroes_283;

/*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class Main {
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int left = 0, index = 0;

        while(index < length){
            printArr(nums);
            if(nums[index] != 0){
                swap(nums, index, left);
                left++;
            }

            index++;
        }
    }

    private static void swap(int[] num, int left, int right){
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }

    private static void printArr(int[] arr){
        for(int num: arr){
            System.out.print(num);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        printArr(nums);
    }
}
