package maximum_product_subarray_152;

/*
    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
    A subarray is a contiguous subsequence of the array.
 */
public class Main {
    public static int maxProduct(int[] nums) {
        int max = 1, min = 1, result = Integer.MIN_VALUE;

        for (int num : nums) {
            int maxCpy = max;
            max = Math.max(max * num, Math.max(min * num, num));
            min = Math.min(maxCpy * num, Math.min(min * num, num));

            result = Math.max(result, Math.max(max, min));
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
        System.out.println(maxProduct(new int[]{0}));
        System.out.println(maxProduct(new int[]{1}));
        System.out.println(maxProduct(new int[]{-1}));
    }
}
