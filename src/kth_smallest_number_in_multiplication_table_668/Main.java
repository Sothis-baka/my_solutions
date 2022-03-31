package kth_smallest_number_in_multiplication_table_668;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
    Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.
 */
public class Main {
    public static int findKthNumber(int m, int n, int k){
        int low = 1, high = m * n;
        while(low < high){
            int mid = low + (high - low) / 2;

            if(enough(mid, m, n, k)) high = mid;
            else low = mid + 1;
        }

        return low;
    }

    private static boolean enough(int val, int m, int n, int k){
        int count = 0;
        for(int i=1; i<=m; i++){
            count += Math.min(val / i, n);
        }
        return count >= k;
    }

    public static void main(String[] args){
        System.out.println(findKthNumber(2,3,6));
    }
}
