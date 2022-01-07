package search_a_2d_matrix_74;

/*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
 */
public class Main {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length, width = matrix[0].length;

        int top = 0, bottom = height-1;
        if(matrix[top][0] == target || matrix[bottom][0] == target){
            // Find it
            return true;
        }else if(matrix[top][0] > target){
            // Out of bound
            return false;
        }

        if(matrix[bottom][0] < target){
            top = bottom;
        }else{
            // Binary search on column
            while(top < bottom - 1){
                int middle = (top + bottom) / 2;
                if(matrix[middle][0] == target){
                    // Find it
                    return true;
                }else if(matrix[middle][0] < target){
                    top = middle;
                }else{
                    bottom = middle;
                }
            }
        }

        // Binary search on the row
        int left = 0, right = width-1;
        if(matrix[top][right] == target){
            // Find it (Already examined the most left one)
            return true;
        }else if(matrix[top][right] > target){
            while (left < right - 1){
                int middle = (left + right) / 2;
                if(matrix[top][middle] == target){
                    // Find it
                    return true;
                }else if(matrix[top][middle] < target){
                    left = middle;
                }else{
                    right = middle;
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 0));
        System.out.println(searchMatrix(new int[][]{{3}}, 3));
    }
}
