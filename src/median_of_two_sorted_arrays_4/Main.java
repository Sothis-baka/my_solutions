package median_of_two_sorted_arrays_4;

/*
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).
 */
public class Main {
    public static void main(String[] args){
        int[] nums1 = new int[]{3,4};
        int[] nums2 = new int[]{1,7,9};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lLength = nums1.length;
        int rLength = nums2.length;

        // only read half of numbers
        int listLength = (lLength + rLength) / 2 + 1;
        int[] nums = new int[listLength];

        int left=0, right=0, cur=0, lNum, rNum;
        while (cur < listLength){
            if(left == lLength){
                // left already finished
                nums[cur] = nums2[right];
                right++;
            } else if(right == rLength){
                // right already finished
                nums[cur] = nums1[left];
                left++;
            } else {
                // use the smaller one
                lNum = nums1[left];
                rNum = nums2[right];

                if(lNum < rNum){
                    nums[cur] = lNum;
                    left++;
                }else {
                    nums[cur] = rNum;
                    right++;
                }
            }

            // update index
            cur++;
        }

        if((lLength+rLength) % 2 == 0){
            // mean of last two
            return ((double)nums[listLength - 1] + (double)nums[listLength - 2]) / 2;
        }else {
            // last one
            return nums[listLength - 1];
        }
    }

}
