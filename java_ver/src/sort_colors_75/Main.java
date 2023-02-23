package sort_colors_75;

/*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem without using the library's sort function.
 */
public class Main {
    public static void sortColors(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1, index = 0;

        // Quick sort
        while(index <= right){
            switch (nums[index]){
                case 0:
                    swap(nums, left, index);
                    left++;
                    index++;
                    break;
                case 1:
                    index++;
                    break;
                case 2:
                    swap(nums, right, index);
                    right--;
                    break;
            }
        }
    }

    // Helper function to swap elements in array
    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static void printArr(int[] temp){
        for(int num: temp){
            System.out.print(num);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] temp = new int[]{2,0,1};
        sortColors(temp);
        printArr(temp);
    }
}
