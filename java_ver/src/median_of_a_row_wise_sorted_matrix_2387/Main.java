package median_of_a_row_wise_sorted_matrix_2387;

/*
    Given an m x n matrix grid containing an odd number of integers where each row is sorted in non-decreasing order, return the median of the matrix.
    You must solve the problem in less than O(m * n) time complexity.
 */
public class Main {
    public int matrixMedian(int[][] grid) {
        /*
            Binary search from min value to max value
            find how many numbers are less than/equal to the val
            Until find the median
         */

        int height = grid.length, width = grid[0].length;
        int l = 0, r = (int) 1e6, half = height * width / 2;

        while (l < r){
            int mid = l + (r - l) / 2;

            if(countSmaller(grid, mid, width) <= half) l = mid + 1;
            else r = mid;
        }

        return r;
    }

    /*
        Count the number of value in the matrix that is less than / equals to the val
     */
    private int countSmaller(int[][] grid, int val, int width){
        int count = 0;
        for(int[] row: grid){
            int l = 0, r = width - 1;

            while (l < r){
                int mid = l + (r - l) / 2;
                if(row[mid] > val) r = mid;
                else l = mid + 1;
            }

            count += row[r] > val ? r : r + 1;
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(new Main().matrixMedian(new int[][]{
                {1, 1, 2},
                {2, 3, 3},
                {1, 3, 4},
        }));

        System.out.println(new Main().matrixMedian(new int[][]{
                {1,1,3,3,4}
        }));
    }
}
