package range_sum_query_2d_immutable_304;

/*
    Given a 2D matrix matrix, handle multiple queries of the following type:

    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
    Implement the NumMatrix class:

    NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class NumMatrix {
    int[][] cache;

    public NumMatrix(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        cache = new int[height + 1][width + 1];

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                int sum = cache[i][j] + matrix[i][j];
                for(int k=0; k<i; k++){
                    sum += matrix[k][j];
                }
                for(int k=0; k<j; k++){
                    sum += matrix[i][k];
                }
                cache[i+1][j+1] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return cache[row2+1][col2+1] - cache[row2+1][col1] - cache[row1][col2+1] + cache[row1][col1];
    }
}