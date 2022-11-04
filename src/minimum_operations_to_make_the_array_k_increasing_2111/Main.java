package minimum_operations_to_make_the_array_k_increasing_2111;

import java.util.ArrayList;
import java.util.List;

/*
    You are given a 0-indexed array arr consisting of n positive integers, and a positive integer k.

    The array arr is called K-increasing if arr[i-k] <= arr[i] holds for every index i, where k <= i <= n-1.

    For example, arr = [4, 1, 5, 2, 6, 2] is K-increasing for k = 2 because:
    arr[0] <= arr[2] (4 <= 5)
    arr[1] <= arr[3] (1 <= 2)
    arr[2] <= arr[4] (5 <= 6)
    arr[3] <= arr[5] (2 <= 2)
    However, the same arr is not K-increasing for k = 1 (because arr[0] > arr[1]) or k = 3 (because arr[0] > arr[3]).
    In one operation, you can choose an index i and change arr[i] into any positive integer.

    Return the minimum number of operations required to make the array K-increasing for the given k.
 */
public class Main {
    public int kIncreasing(int[] arr, int k) {
        /*
            A k-increasing arr can be divided into k-1 arrays
            [0, 0+k, 0+2k, ...]
            [1, 1+k, 1+2k, ...]
            [2, 2+k, 2+2k, ...]
            ...
            [k-1, k-1+k, k-1+2k, ...]

            And for each array from them, arr[i] should <= arr[i-1]
         */
        int length = arr.length, result = 0;
        for(int i=0; i<k; i++){
            /*
                For each array arr, find the maximum increasing indexes m,
                and the operations need to make it non-decreasing is arr.length - m

                To find the maximum increasing indexes,
                we use an ArrayList to save current increasing indexes.
                For a new indexes,
                if it's larger than or equals to all, append it,
                otherwise, replace the value just larger than it with itself

                [1, 3], 4 -> [1, 3, 4]
                [1, 3], 2 -> ]1, 2]
             */
            List<Integer> currentIncArr = new ArrayList<>();
            int l = 0;
            for(int j=i; j<length; j+=k){
                int val = arr[j];
                if(currentIncArr.isEmpty() || currentIncArr.get(currentIncArr.size() - 1) <= val)
                    currentIncArr.add(val);
                else currentIncArr.set(indexLargerThanVal(currentIncArr, val), val);

                l++;
            }

            result += l - currentIncArr.size();
        }

        return result;
    }

    /*
        Helper function
        Use binary search to find i that arr[i] > val & (!arr[i-1] | arr[i-1] <= val)
     */
    private int indexLargerThanVal(List<Integer> arr, int val){
        int l = 0, r = arr.size() - 1;

        // If it's the smallest value
        if(arr.get(0) > val) return 0;

        // Right will always be larger than val, so it won't be infinity
        while(l < r){
            int mid = (r - l) / 2 + l;

            if(arr.get(mid) <= val) l = mid + 1;
            else r = mid;
        }

        return l;
    }

    public static void main(String[] args){
        System.out.println(new Main().kIncreasing(new int[]{12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3}, 1));
    }
}
